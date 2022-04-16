import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.spongepowered.plugin.metadata.model.PluginDependency
import org.spongepowered.gradle.plugin.config.PluginLoaders

plugins {
    id("java-library") apply(true)

    id("org.spongepowered.gradle.plugin") version "2.0.0" apply(true)
    id("com.github.johnrengelman.shadow") version "7.1.2" apply(true)
}

group = "ovh.icewynd.devola"
version = "0.0.1-SNAPSHOT"
description = "Example template for Sponge plugins."

tasks {
    withType(JavaCompile::class.java) {
        options.release.set(17)
        options.encoding = "UTF-8"
    }

    withType(ShadowJar::class.java) {
        archiveBaseName.set(rootProject.name)
        archiveVersion.set(rootProject.version.toString())

        archiveClassifier.set("")
    }
}

dependencies {
    compileOnly("org.spongepowered:spongeapi:8.0.0")
    annotationProcessor("org.spongepowered:spongeapi:8.0.0")
}

sponge {
    apiVersion("8.0.0")
    license("MIT")

    loader {
        name(PluginLoaders.JAVA_PLAIN)
        version(rootProject.version.toString())
    }

    plugin(rootProject.name) {
        displayName(rootProject.name)
        entrypoint("ovh.icewynd.devola.DevolaPlugin")
        description(rootProject.description)

        links {
            homepage("https://icewynd.ovh/projects/devola")
            source("https://github.com/sBwAeBeYt/devola")
        }

        contributor("sBwAeBeYt") {
            description("General author")
        }

        dependency("spongeapi") {
            loadOrder(PluginDependency.LoadOrder.AFTER)
            optional(false)
        }
    }
}

repositories {
    maven { url = uri("https://repo.spongepowered.org/repository/maven-public") }
    mavenCentral()
}