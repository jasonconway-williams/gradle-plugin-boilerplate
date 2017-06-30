package com.plugin.boilerplate.plugin

import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.UnexpectedBuildFailure
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import spock.lang.Specification

import static org.gradle.testkit.runner.TaskOutcome.*

/**
 * Test the PluginBoilerplate plugin, extension and task.
 */
class PluginBoilerplateTest extends Specification {

    private static final def testConfigContent = '"boilerplate-value-1" : "test value for boilerplate value 1"'
    private static def testConfig = """
        {
            ${testConfigContent}
        }
        """

    @Rule final TemporaryFolder testProjectDir = new TemporaryFolder()
    File buildFile
    File configFile
    File configurationFile

    def setup() {
        configurationFile = new File("build/configuration.json")
        configurationFile.delete()
        buildFile = testProjectDir.newFile('build.gradle')
        configFile = testProjectDir.newFile('config.json')
        configFile << testConfig
    }

    def "Successful run of the plugin creating a config file."() {
        given:
        buildFile << """
            plugins {
                id 'BoilerplatePlugin'
            }
            
            boilerplate {
                configFilePath = "${configFile.absolutePath}"
            }
        """

        when:
        def result = GradleRunner.create()
                .withProjectDir(testProjectDir.root)
                .withArguments('boilerplate-task')
                .withPluginClasspath()
                .build()

        configurationFile = new File("build/configuration.json")

        then:
        result.task(":boilerplate-task").outcome == SUCCESS
        configurationFile.exists()
        configurationFile.text.contains(testConfigContent)
    }

    def "Invalid config"() {
        given:
        buildFile << """
            plugins {
                id 'BoilerplatePlugin'
            }
        """

        when:
        def result = GradleRunner.create()
                .withProjectDir(testProjectDir.root)
                .withArguments('boilerplate-task')
                .withPluginClasspath()
                .build()

        configurationFile = new File("build/configuration.json")

        then:
        thrown(UnexpectedBuildFailure)
    }
}

