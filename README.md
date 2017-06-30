# Plugin Boilerplate

This project provides a boilerplate for gradle projects that implement an internal custom plugin. Gradle looks for and
 inspects the `buildSrc` directory at build time to load any custom plugins and tasks. The `buildSrc` itself can be
 configured to be multimodule so you can include one or many internal plugins.

The `buildSrc` directory contains the main plugin class (`BoilerplatePlugin`), the plugin extensions class
(`BoilerplatePluginExtension`) which contains task specific configuration values, and a task class (`BoilerplateTask`)
which contains the custom task.

The `buildSrc` directory also contains the `/Users/jasonconway-williams/dev/plugin-boilerplate/buildSrc/src/main/
resources/META-INF/gradle-plugins/BoilerplatePlugin.properties` file which is used internally by gradle to determine the
plugin name and main implementing class (`BoilerplatePlugin.java`).

## Structure

The project consists of the following structure:

    |-- buildSrc                                                    -> buildSrc directory containing internal custom
    |    |                                                             gradle task and configuration.
    |    |--- src
    |    |     |-- main
    |    |     |     |-- groovy                                     -> src directory containing the custom plugin
    |    |     |     |                                                 classes.
    |    |     |     |-- resources                                  -> buildSrc resources directory.
    |    |     |            |-- META-INF
    |    |     |                    |-- gradle-plugind
    |    |     |                             |-- plugin.properties  -> Plugin properties file containing the main
    |    |     |                                                       implementing plugin class.
    |    |     |
    |    |     |-- test
    |    |          |-- groovy                                      -> test directory containing the plugin tests.
    |    |
    |    |--- build.gradle                                          -> buildSrc build.gradle file containing project
    |                                                                  specific configuration such as dependencies.
    |
    |-- src                                                         -> Project src directory containing project
    |     |                                                            application code.
    |     |
    |     |--- main
    |     |      |--- java                                           -> Java directory containing Java application code.
    |     |      |--- resources                                      -> Application resources directory.
    |     |
    |     |--- test
    |            |--- java                                           -> Java test classes.
    |            |--- resources                                      -> Test resources.
    |
    |-- build.gradle                                                 -> Project build file.
    |-- settings.gradle                                              -> Gradle settings file.
    |-- gradle                                                       -> Gradle wrapper.
           |
           |-- wrapper

