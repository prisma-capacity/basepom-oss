#!/usr/bin/env kotlin

@file:DependsOn("io.github.typesafegithub:github-workflows-kt:3.5.0")

@file:Repository("https://repo.maven.apache.org/maven2/")
@file:Repository("https://bindings.krzeminski.it")

@file:DependsOn("actions:checkout:v4")
@file:DependsOn("actions:setup-java:v5")

import io.github.typesafegithub.workflows.actions.actions.Checkout
import io.github.typesafegithub.workflows.actions.actions.SetupJava

import io.github.typesafegithub.workflows.domain.RunnerType
import io.github.typesafegithub.workflows.domain.triggers.Push
import io.github.typesafegithub.workflows.dsl.workflow
import java.nio.file.Paths

val workflowMaven = workflow(
    name = "Java CI",
    on = listOf(
        Push(),
    ),
    sourceFile =  __FILE__,
) {
    job(
        id = "build",
        runsOn = RunnerType.UbuntuLatest,
    ) {
        uses(
            name = "Checkout",
            action = Checkout(),
        )
        uses(
            name = "Set up JDK 1.8",
            action = SetupJava(
                javaVersion = "8",
                distribution = SetupJava.Distribution.Corretto
            ),
        )
        run(
            name = "Build with Maven",
            command = "mvn -B package --file pom.xml",
        )
    }

}

