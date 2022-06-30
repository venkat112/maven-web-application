package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.triggers.vcs

object CiCdDemo : BuildType({
    name = "ci-cd_demo"

    params {
        param("repository", "maven-web-application")
    }

    vcs {
        root(CiCdSource)
    }

    steps {
        maven {
            name = "cleaning"
            goals = "clean"
        }
        maven {
            name = "testing"
            goals = "test"
        }
        maven {
            name = "package"
            goals = "package"
        }
    }

    triggers {
        vcs {
            branchFilter = ""
        }
    }
})
