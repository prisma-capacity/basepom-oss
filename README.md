<div align="right"><a target="myNextJob" href="https://www.prisma-capacity.eu/careers#job-offers">
    <img class="inline" src="prisma.png">
</a></div>

### Base POM for Open-Source Projects published by PRISMA European Capacity Platform GmbH

![Java CI](https://github.com/prisma-capacity/basepom-oss/workflows/Java%20CI/badge.svg?branch=master)
[![MavenCentral](https://img.shields.io/maven-central/v/eu.prismacapacity/basepom-oss)](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22eu.prismacapacity%22)
<a href="https://www.apache.org/licenses/LICENSE-2.0">
    <img class="inline" src="https://img.shields.io/badge/license-ASL2-green.svg?style=flat">
</a>
[![Dependabot Status](https://api.dependabot.com/badges/status?host=github&repo=prisma-capacity/basepom-oss)](https://dependabot.com)

This POM provides some reasonable default plugin configurations. In order to disable preconfigured plugins, add a .noXXXX File to the root of your repository. (See pom.xml for exact filenames)

To use this in OSS projects define a parent in your ```pom.xml```

```
<parent>
	<groupId>eu.prismacapacity</groupId>
	<artifactId>basepom-oss</artifactId>
	<version>0.1.0</version> <!-- or the current version -->
</parent>
```
---
