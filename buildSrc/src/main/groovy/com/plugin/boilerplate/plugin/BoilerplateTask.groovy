package com.plugin.boilerplate.plugin

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Boilerplate task example.
 * This task uses the default gradle logger to output info messages.
 * Run the task with `-i` to display the info log messages.
 */
class BoilerplateTask extends DefaultTask {

    @TaskAction
    generateFile() {

        def logger = project.logger

        logger.info("Starting the boilerplate task...")

        def configFile = new File(project.boilerplate.configFilePath)

        if (!configFile.exists()) {
            throw new IllegalArgumentException("Could not generate the configuration file. Please provide a valid config file path.")
        }

        logger.info("Retrieved the config file located at ${project.boilerplate.configFilePath}")

        def mapper = new ObjectMapper()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        def config = mapper.readTree(configFile)

        logger.info("Creating the configuration output file...")
        def node = mapper.createObjectNode()
        node.set("config", config)
        new File("build").mkdir()

        mapper.writeValue(new File("build/configuration.json"), node)
        logger.info("Configuration output file created.")
    }
}
