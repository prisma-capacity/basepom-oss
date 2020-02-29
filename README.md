<div align="right"><a target="myNextJob" href="https://www.prisma-capacity.eu/careers#job-offers">
    <img class="inline" src="prisma.png">
</a></div>

### Base POM for Open-Source Projects published by PRISMA European Capacity Platform GmbH

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
