package guru.ioio.aop.plugin

import org.gradle.api.Project
import org.gradle.api.Plugin

class DemoPlugin:Plugin<Project>{
    override fun apply(p0: Project) {
        println("*** demo ***")
    }

}