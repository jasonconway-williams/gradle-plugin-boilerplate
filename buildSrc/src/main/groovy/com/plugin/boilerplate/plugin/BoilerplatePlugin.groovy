package com.plugin.boilerplate.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * BoilerplatePlugin is the internal task that will be made available to the build script.
 */
class BoilerplatePlugin implements Plugin<Project> {
    void apply(Project project) {
        // Add the task extension to the project.
        project.extensions.add("boilerplate", BoilerplatePluginExtension)
        // Add the task to the project.
        project.tasks.create("boilerplate-task", BoilerplateTask)
    }
}