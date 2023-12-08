#!/usr/bin/env kotlin

@file:DependsOn("io.github.typesafegithub:github-workflows-kt:1.7.0")

import io.github.typesafegithub.workflows.actions.actions.CheckoutV4
import io.github.typesafegithub.workflows.actions.actions.SetupJavaV3
import io.github.typesafegithub.workflows.domain.RunnerType
import io.github.typesafegithub.workflows.domain.triggers.Push
import io.github.typesafegithub.workflows.dsl.workflow
import io.github.typesafegithub.workflows.yaml.writeToFile
import java.nio.file.Paths

val workflowMaven = workflow(
    name = "Java CI",
    on = listOf(
        Push(),
    ),
    sourceFile =  __FILE__.toPath(),
) {
    job(
        id = "build",
        runsOn = RunnerType.UbuntuLatest,
    ) {
        uses(
            name = "Checkout",
            action = CheckoutV4(),
        )
        uses(
            name = "Set up JDK 1.8",
            action = SetupJavaV3(
                javaVersion = "8",
                distribution = SetupJavaV3.Distribution.Corretto
            ),
        )
        run(
            name = "Build with Maven",
            command = "mvn -B package --file pom.xml",
        )
    }

}

workflowMaven.writeToFile()
