#!/usr/bin/env kotlin

@file:DependsOn("it.krzeminski:github-actions-kotlin-dsl:0.20.0")

import it.krzeminski.githubactions.actions.actions.CheckoutV3
import it.krzeminski.githubactions.actions.actions.SetupJavaV3
import it.krzeminski.githubactions.domain.RunnerType
import it.krzeminski.githubactions.domain.Workflow
import it.krzeminski.githubactions.domain.triggers.Push
import it.krzeminski.githubactions.dsl.workflow
import it.krzeminski.githubactions.yaml.writeToFile
import java.nio.file.Paths

public val workflowMaven: Workflow = workflow(
    name = "Java CI",
    on = listOf(
        Push(),
    ),
    sourceFile = Paths.get("./.github/kts/maven.main.kts"),
) {
    job(
        id = "build",
        runsOn = RunnerType.UbuntuLatest,
    ) {
        uses(
            name = "Checkout",
            action = CheckoutV3(),
        )
        uses(
            name = "Set up JDK 1.8",
            action = SetupJavaV3(
                javaVersion = "8.0",
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
