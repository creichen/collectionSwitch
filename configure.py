#!/usr/bin/env python3
# configure.py: General-purpose-ish configuration script for Java projects
#
# (C) 2022 Christoph Reichenbach, released into the public domain
#
# The configuration is stored in a json file
#
# Intended for copy-and-paste reproduction and for inclusion by other
# scripts that want to access the configuration from Python.

###################################################
# Preamble: common for all configure.py
###################################################

CONF_VERSION='0.1.3' # version of the general-purpose parts of the configuration script
_CONFIGURE_PY_MAGIC='magic'

def OPT(feature, description):
    return ('opt', description, feature)

def getOPT(dependency, feature=False):
    if type(dependency) == tuple and dependency[0] == 'opt':
        return dependency[2 if feature else 1]

###################################################
# Project details: adjust for this project
################################################################################

NAME='collection-switch'

# Where to store the configuration
CONFFILE_JSON='.config.json' # canonical configuration file
CONFFILE_ANT_PROPERTIES='.config.properties' # Ant properties file, overwritten; or None
CONFFILE_SH='.config.sh' # sh-script config file, or None
CLASSPATH_FILE='.classpath' # Eclipse JDT classpath file, or None
POM_TEMPLATE='pom.template.xml' # pom.xml template, or None

# Constants for optional features, if any
FEATURES={}

# Jar files that must be supplied
JAR_DEPS = {
    # required:
    #    'foo.jar' : 'description',
    # optional:
    #    'foo.jar' : OPT('feature','description'),
    # ...where 'feature' is the feature that depends on this library
    'smrt.jar'		: 'Smart Modules for Java: Runtime collection classes',
}

# .so libraries that must be supplied
SO_DEPS = {
    # analogous to JAR_DEPS
}


# ----------------------------------------
# For generating the .classpath file (optional)
SRCPATHS = [
    'src/main/java',
    'src/test/java',
]

BUILDPATH = 'build/main'

# For generating the .classpath file (optional)
JARPATHS = []


# ----------------------------------------
# Hook to run after successful configuration, if any
def HOOK():
    pass

################################################################################
# Body: common for all configure.py
#########################################

import sys
import os
import json
import argparse
import glob

CONFIG_HOME = os.path.dirname(os.path.realpath(__file__)) if '__file__' in globals() else '.'

def perr(*args, **kwargs):
    print(*args, file=sys.stderr, **kwargs)


def libraries_and_features_description():
    def pad(n):
        def p(s):
            return s + (' ' * (n - len(s)))
        return p

    max_lib_strlen = max([len(s) for s in (set([] if JAR_DEPS is None else JAR_DEPS.keys()) | set([] if SO_DEPS is None else SO_DEPS.keys()))])
    pad_libname = pad(max_lib_strlen)

    max_feature_strlen = 0 if not FEATURES else max([len(s) for s in FEATURES.keys()])
    pad_feature = pad(max_feature_strlen)

    # compute the string for features
    items = []
    for depmap in [JAR_DEPS, SO_DEPS]:
        if not depmap:
            continue
        for name, description in depmap.items():
            name = '  ' + pad_libname(name) + '    '
            if getOPT(description):
                feature = getOPT(description, feature=True)
                items.append((feature, name + f'[{feature}] ' + getOPT(description)))
            else:
                items.append(('', name + description))

    items.sort()
    epilogue = ('Libraries:\n' + '\n'.join([item[1] for item in items]) + '\n') if items else ''

    features = ''
    if FEATURES:
        features = ('Optional features: \n' +
                    '\n'.join([ ('  ' + pad_feature(feature) + '  ' + description + '\n')
                                for (feature, description) in FEATURES.items()])
                    + '\n')

    epilogue = '\n'.join([s for s in [epilogue,
                                      features]
                          if s != ''])
    return epilogue


class LibBinding:
    def __init__(self, keyvalue):
        tokens = keyvalue.split('=')
        self.error = None

        if len(tokens) == 1:
            # infer the key
            tokens = [keyvalue.split(os.path.sep)[-1],
                      keyvalue]

        if len(tokens) != 2:
            self.error = f'Argument "{keyvalue}" does not follow the structure "[library]=[location]"'
        else:
            key, value = tokens
            if key not in JAR_DEPS and key not in SO_DEPS:
                self.error = f'Unknown library: "f{key}"'
            else:
                self.lib = key
                self.location = value

parser = argparse.ArgumentParser(description=f'Configuration script for {NAME}.',
                                 epilog = libraries_and_features_description(),
                                 formatter_class = argparse.RawTextHelpFormatter)
parser.add_argument('-v', '--version', action='version',
                    version='Version ' + CONF_VERSION,
                    help='Shows the version of the configuration script')
parser.add_argument('lib_bindings', metavar='LIB=LOC', type=LibBinding, nargs='*',
                    help='A list of library-to-location bindings, e.g., "foo.jar=../../foo.jar"')
parser.add_argument('-i', '--info', action='store_const',
                    dest='request',
                    const='info', default='configure',
                    help='Display the current configuration')
parser.add_argument('-d', '--disable', action='append',
                    dest='disabled_features',
                    help='Disable an optional feature')

class ConfigSource:
    '''
    key-value mapping for configurations
    '''
    def __init__(self, confmap={}):
        self.confmap = confmap

    def __getitem__(self, key):
        if key not in self:
            return None
        location = ConfigSource.locate_file(self.confmap[key])
        if location is None:
            perr(f'Warning: could not find library file for binding key={self.confmap[key]}')
        return location

    def __contains__(self, key):
        return key in self.confmap

    @staticmethod
    def from_lib_bindings(lib_bindings):
        result = {}
        for l in lib_bindings:
            if l.error is None:
                if result is not None:
                    result[l.lib] = l.location
            else:
                perr(l.error)

        return ConfigSource(result) if result else None

    @staticmethod
    def locate_file(filename):
        filename = os.path.expanduser(filename)

        if os.path.isfile(filename):
            return os.path.abspath(filename)


class ConfigSourcePathList(ConfigSource):
    '''
    Configuration for files that draws from a list of file names or paths
    '''
    def __init__(self, paths):
        ConfigSource.__init__(self)
        self.paths = paths

    def __getitem__(self, key):
        for p_base in self.paths:
            # try each path both as filename and as path that contains the file of the desired name
            for p in [p_base,
                      '' if p_base == '' else (p_base + os.path.sep + key)]:
                if not p.endswith(key):
                    continue
                result = ConfigSource.locate_file(p)
                if result:
                    return result
        return None # not found


class ConfigSourceEnvPath(ConfigSourcePathList):
    '''
    Configuration for files that draws from an environment variable that describes a colon-separated list of paths
    '''

    def __init__(self, env_var):
        strings = os.environ.get(env_var)
        if strings:
            strings = strings.split(':')

            # Correct handling of escaped ':'
            paths = []
            path_prefix = None
            for path_fragment in strings:
                if path_prefix is not None:
                    path_fragment = path_prefix + ':' + path_fragment
                    path_prefix = None
                if len(path_fragment) > 0 and path_fragment[-1] == '\\':
                    path_prefix = path_fragment
                else:
                    paths.append(path_fragment)
            if path_prefix:
                paths.append(path_fragment)
            ConfigSourcePathList.__init__(self, paths)
        else:
            ConfigSourcePathList.__init__(self, [])


class Configuration:
    def __init__(self):
        self.loaded = False
        self.config = {}
        self.path = CONFIG_HOME
        self.deps_map = {
            'so':	SO_DEPS,
            'jar':	JAR_DEPS,
        }

        self.config_sources = {}
        for n in self.config_source_types:
            self.config_sources[n] = []

        self.add_config_source('$CLASSPATH', ConfigSourceEnvPath('CLASSPATH'), kind='jar')
        self.add_config_source('$LD_LIBRARY_PATH', ConfigSourceEnvPath('LD_LIBRARY_PATH'), kind='so')
        self.add_config_source('$LD_RUN_PATH', ConfigSourceEnvPath('LD_RUN_PATH'), kind='so')
        self.feature_deps = self._compute_feature_deps()
        self.blocklisted_features = []

    def absolute_path(self, filename):
        '''Absolute path relative to the configure.py script itself'''
        return os.path.abspath(os.path.join(self.path, filename))

    @property
    def config_source_types(self):
        '''
        Set of types of library dependencies ('jar', 'so' etc.) as strings.
        '''
        return self.deps_map.keys()

    def __getitem__(self, prop):
        '''
        Reads out the library mapping or feature flag.  String for library mappings, bool for features.
        '''
        return self.config[prop]

    def __contains__(self, prop):
        '''
        Checks whether a library is present or a feature is enabled.

        Disabled and non-existent features are treated identically.  To explicitly check for
        disabled features, use `self.features(disabled=True)`.
        '''
        if prop in self.feature_deps:
            return self[prop]
        return prop in self.config

    def deps(self, optional=True, required=True, deptype=True):
        '''
        Dependencies as tuples:
        (name, deptype, description, features?)

        - name: library name
        - deptype: "jar", "so" etc.
        - description: human-readable description
        - features: None if required dependency, otherwise the set of features that depend on this library
        '''

        if type(deptype) is str:
            deptype = set([deptype])
        # deptype is either True (for 'anything goes') or the set of valid config_source_types

        for config_source_type, depsmap in self.deps_map.items():

            if depsmap is None:
                continue

            for (name, description) in depsmap.items():
                feature_set = getOPT(description, feature=True)
                this_is_required = not feature_set

                if not optional and not this_is_required:
                    continue
                if not required and this_is_required:
                    continue
                if deptype != True and config_source_type not in deptype:
                    continue
                if type(feature_set) is str:
                    feature_set = set([feature_set])

                yield (name, config_source_type, description, feature_set)

    def add_config_source(self, name, source, kind=None):
        '''
        Prepend a new configuration source

        'kind' can be a configuration file type (e.g., 'jar' or 'so')
        '''
        kinds = kind
        if kind is None:
            kinds = self.config_source_types
        if type(kind) is str:
            kinds = [kind]

        new_conf = (name, source)

        for config_kind in kinds:
            self.config_sources[config_kind] = [new_conf] + self.config_sources[config_kind]

    def _compute_feature_deps(self):
        '''
        Computes all feature dependencies
        '''
        if FEATURES is None:
            return {}

        declared_deps = {}

        for feature in FEATURES.keys():
            declared_deps[feature] = set()

        for (lib, _, _, lib_features) in self.deps(optional=True, required=False):
            for lib_feature in lib_features:
                if lib_feature not in declared_deps:
                    raise Exception(f'Configure script not set up properly: library {lib} supports feature {lib_feature}, but that feature is not listed in FEATURES')
                declared_deps[lib_feature].add(lib)
        return declared_deps

    def find_config(self, verbose=False) -> bool:
        '''
        Try to find library bindings for all configuration options.  Stores the bindings in `self.config`,
        including updated feature flags.
        '''

        lib_bindings = {}
        self.config = {}

        failures = []

        for config_source_type in self.config_source_types:
            if self.deps_map[config_source_type] is None:
                continue

            sources = self.config_sources[config_source_type]
            def bind(name):
                for (descr, source) in sources:
                    if source is None:
                        continue
                    binding = source[name]
                    if binding is not None:
                        print(f'{name}:\n  FOUND at {binding} (from {descr})')
                        return binding

            for (name, description) in self.deps_map[config_source_type].items():
                binding = bind(name)
                if binding is not None:
                    lib_bindings[name] = binding
                else:
                    if not getOPT(description):
                        perr(f'{name}:\n  NOT found')
                        failures.append(name)

        if failures:
            perr('Failed to find the following libraries: ' + ', '.join(failures))
            return False
        self.config = lib_bindings

        # Now check features for completeness
        for feature in self.feature_deps.keys():
            self.config[feature] = self.feature_available(feature)

        return True

    def feature_available(self, feature_name):
        if feature_name in self.blocklisted_features:
            return False
        lib_bindings = self.config
        deps = self.feature_deps[feature_name]
        all_bindings_satisfied = ([] == [dep for dep in deps if dep not in lib_bindings])
        return all_bindings_satisfied

    def validate(self, force_reconfig=False, verbose=False) -> bool:
        '''
        Are all mandatory configuration options set?
        Prints errors as appropriate
        '''
        if force_reconfig or not self.loaded:
            if not self.find_config(verbose=verbose):
                return False  # Has already reported any issues

        missing_libs = []
        for (name, _, _, _) in self.deps(optional=False):
            if name not in self:
                missing_libs.append(name)

        if missing_libs and verbose:
            perr('Missing required libraries:')
            for l in missing_libs:
                perr(f'  {l}')

        return not missing_libs

    def features(self, enabled=True, disabled=False) -> list[str]:
        '''
        All features (elements of FEATURES).  'disabled' and 'enabled' select which features to return.
        '''
        availability = []
        if enabled:
            availability.append(True)
        if disabled:
            availability.append(False)
        return [feature for feature in self.feature_deps.keys() if self.feature_available(feature) in availability]

    def ant_properties(self):
        properties = {}
        for (libname, config_source_type, _, _) in self.deps():
            if libname in self:
                properties[f'lib.{config_source_type}.{libname}'] = self.config[libname]
            for feature in self.features():
                properties[f'feature.{feature}'] = 'true'
        return properties

    def emit_pom_xml(self):
        if POM_TEMPLATE:
            with open(POM_TEMPLATE, 'r') as infile:
                body = infile.read()
            for (key, value) in self.ant_properties().items():
                body = body.replace('${' + key + '}', value)
            with open('pom.xml', 'w') as outfile:
                outfile.write(body)

    def emit_ant_properties(self):
        '''
        Stores ant properties file
        '''
        # propagate exception on error
        if CONFFILE_ANT_PROPERTIES is not None:
            with open(self.absolute_path(CONFFILE_ANT_PROPERTIES), 'w') as outfile:
                for (key, value) in self.ant_properties().items():
                    print(f'{key}={value}',
                          file=outfile)

    def emit_config_sh(self):
        def to_var(v):
            return v.upper().replace('.', '_').replace('-', '_')
        if CONFFILE_SH is not None:
            with open(self.absolute_path(CONFFILE_SH), 'w') as outfile:
                print('#! /bin/sh',
                      file=outfile)
                for (libname, config_source_type, _, _) in self.deps():
                   if libname in self:
                       print(f'SM_LIB_{to_var(libname)}={self.config[libname]}',
                              file=outfile)
                for feature in self.features(enabled=True, disabled=False):
                    print(f'SM_FEATURE_{to_var(feature)}=true',
                          file=outfile)

    def emit_classpath_file(self):
        '''
        Emits a '.classpath' file for Eclipse/JDT
        '''
        if CLASSPATH_FILE and (SRCPATHS or JARPATHS):
            from xml.sax.saxutils import escape

            entries = [('con', 'org.eclipse.jdt.launching.JRE_CONTAINER')]
            for src in SRCPATHS:
                entries.append(('src', src))
            for (dep, _, _, _) in self.deps(deptype='jar'):
                if dep in self:
                    entries.append(('lib', self[dep]))
            for jarpath in JARPATHS:
                for filename in os.listdir(jarpath):
                    if filename.endswith('.jar'):
                        jarname = self.absolute_path(os.path.join(jarpath, filename))
                        entries.append(('lib', jarname))
            if BUILDPATH:
                entries.append(('output', BUILDPATH))

            with open(self.absolute_path(CLASSPATH_FILE), 'w') as outfile:
                print('<?xml version="1.0" encoding="UTF-8"?>\n<classpath>',
                      file=outfile)
                for (kind, path) in entries:
                    print(f'        <classpathentry kind="{escape(kind)}" path="{escape(path)}"/>',
                          file=outfile)
                print('</classpath>\n',
                      file=outfile)

    def disable_features(self, features):
        '''
        Explicitly disable some features
        '''
        if features is None:
            return

        for feature in features:
            if not FEATURES or feature not in FEATURES:
                perr(f'WARNING: unknown feature "{feature}"');
            else:
                self.blocklisted_features.append(feature)

    def save(self):
        '''
        Store configuration data
        '''
        # propagate exception on error
        with open(self.absolute_path(CONFFILE_JSON), 'w') as outfile:
            outfile.write(json.dumps(self.config, indent=4))
            outfile.write('\n')

    def load(self) -> bool:
        '''
        Try to load configuration data from disk
        '''
        try:
            with open(self.absolute_path(CONFFILE_JSON), 'r') as infile:
                self.config = json.load(infile)
                self.loaded = True
        except FileNotFoundError:
            return False
        except json.JSONDecodeError as err:
            perr(f'Failed to parse {CONFFILE_JSON}: {err}')
            return False

config = Configuration()

if __name__ == '__main__':  # otherwise the hook library is referencing us
    config.load()
    args = parser.parse_args()
    if args.request == 'info':
        if not config.validate():
            perr(f'No valid configuration for {NAME}; re-run {sys.argv[0]} to fix')
            sys.exit(1)
        print('FIXME')
    elif args.request == 'configure':
        config.add_config_source('command line parameters', ConfigSource.from_lib_bindings(args.lib_bindings))
        config.disable_features(args.disabled_features)
        if config.validate(force_reconfig=True, verbose=True):
            # configuration succeeded
            config.save()
            _CONFIGURE_PY_MAGIC = 'empty'
            config.emit_ant_properties()
            config.emit_classpath_file()
            config.emit_config_sh()
            config.emit_pom_xml()
            enabled_features = config.features(enabled=True, disabled=False)
            disabled_features = config.features(enabled=False, disabled=True)
            if disabled_features:
                print(f'Disabled features: {", ".join(disabled_features)}')
            if enabled_features:
                print(f'Enabled features: {", ".join(enabled_features)}')
            if HOOK:
                HOOK()
            sys.exit(0) # success
        else:
            perr('Please fix the above errors and re-run the configuration script.')
            sys.exit(1)
    else:
        # Should not be possible
        perr('Unsupported request')
        sys.exit(1)
else:
    try:
        import __main__
        if __main__._CONFIGURE_PY_MAGIC != 'magic':
            raise Exception('Wrong main module or in the midst of configuring')
        config = __main__.config
    except:
        config.load()

    if not config.validate():
        perr(f'No valid configuration for {NAME}: re-run the configuration script.  Aborting...')
        sys.exit(1)
