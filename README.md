[![Build Status](https://travis-ci.org/jacek-rzrz/rzrz-java-lang.svg?branch=master)](https://travis-ci.org/jacek-rzrz/rzrz-java-lang)

# rzrz-java-lang
Zero-dependency library providing language utilities:
convenient exception constructors, a Try class, tuples.

## Exceptions
`rzrz.java.lang.Exceptions` contains number of classes extending runtime exceptions
from the `java.lang` package. Their constructors accept message formats and format arguments,
so one can write:

    throw new IllegalArgument("Lengths unequal - x: %d, y: %d", x.size(), y.size());

Rather than:

    throw new IllegalArgumentException("Lengths unequal - x: " + x.size() + ", y: " + y.size());

## Tuples
TODO: brief description with examples

## Try
TODO: brief description with examples


# Binaries
Snapshots built from `master` branch are available from Sonatype OSSRH:

    <repositories>
        <repository>
            <id>ossrh</id>
            <name>Sonatype OSSRH</name>
            <url>https://oss.sonatype.org/content/repositories/snapshots</url>
        </repository>
    </repositories>
    
    <dependencies>
        <dependency>
            <groupId>pl.rzrz</groupId>
            <artifactId>java-lang</artifactId>
            <version>1.0.0-SNAPSHOT</version>
        </dependency>
    </dependencies>