# Overview

<div style="text-align: center">

[![Java CI with Gradle](https://github.com/astrapi69/swing-model-components/actions/workflows/gradle.yml/badge.svg)](https://github.com/astrapi69/swing-model-components/actions/workflows/gradle.yml)
[![Coverage Status](https://codecov.io/gh/astrapi69/swing-model-components/branch/develop/graph/badge.svg)](https://codecov.io/gh/astrapi69/swing-model-components)
[![Open Issues](https://img.shields.io/github/issues/astrapi69/swing-model-components.svg?style=flat)](https://github.com/astrapi69/swing-model-components/issues)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/swing-model-components/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/swing-model-components)
[![Javadocs](http://www.javadoc.io/badge/io.github.astrapi69/swing-model-components.svg)](http://www.javadoc.io/doc/io.github.astrapi69/swing-model-components)
[![MIT License](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)
[![Hits Of Code](https://hitsofcode.com/github/astrapi69/swing-model-components?branch=develop)](https://hitsofcode.com/github/astrapi69/swing-model-components/view?branch=develop)
[![Lines Of Code](https://tokei.rs/b1/github/astrapi69/swing-model-components)](https://github.com/astrapi69/swing-model-components)

</div>

This repository contains a set of custom Swing components that extend the basic functionality provided by the standard
Swing components. Additionally, there is a feature to save a `Model` object, which can be integrated into your application.

> Please support this project by simply putting a Github <a class="github-button" href="https://github.com/astrapi69/swing-model-components" data-icon="octicon-star" aria-label="Star astrapi69/swing-model-components on GitHub">
> Star ⭐</a>
>
> Share this library with friends on Twitter and everywhere else you can
>
> If you love this project
> [![Donation](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)

## Components Overview

Below is a brief description of each custom component provided:

- **JMBigDecimalTextField**: A text field component specifically for handling `BigDecimal` input.
- **JMBigIntegerTextField**: A text field component for handling `BigInteger` input.
- **JMCheckBox**: A custom checkbox component.
- **JMComboBox**: A combo box component with extended features.
- **JMFormattedTextField**: A text field with formatted input.
- **JMGenericTextField**: A generic text field that can be customized.
- **JMIntegerTextField**: A text field specifically for integer input.
- **JMLabel**: A custom label component.
- **JMPasswordField**: A text field for entering passwords.
- **JMSpinner**: A spinner component for selecting numbers.
- **JMStringTextField**: A text field for handling string input.
- **JMTextArea**: A custom text area component.
- **JMTextField**: A general-purpose text field.

## Note

No animals were harmed in the making of this library.

## License

The source code comes under the liberal MIT License, making swing-model-components great for all types of applications.

## gradle dependency

Replace the variable ${latestVersion} with the current latest version: [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/swing-model-components/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/swing-model-components)

You can first define the version in the ext section and add than the following gradle dependency to
your project `build.gradle` if you want to import the core functionality of swing-model-components:

define version in file gradle.properties

```
swingModelComponentsVersion=${latestVersion}
```

or in build.gradle ext area

```
    swingModelComponentsVersion = "${latestVersion}"
```

then add the dependency to the dependencies area

```
    implementation("io.github.astrapi69:swing-model-components:$swingModelComponentsVersion")
```

## Maven dependency

Maven dependency is now on sonatype.
Check out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~io.github.astrapi69~swing-model-components~~~) for latest snapshots and releases.

Add the following maven dependency to your project `pom.xml` if you want to import the core
functionality of swing-model-components:

Then you can add the dependency to your dependencies:

    <properties>
            ...
        <!-- swing-model-components version -->
        <swing-model-components.version>${latestVersion}</swing-model-components.version>
            ...
    </properties>
            ...
        <dependencies>
            ...
            <!-- swing-model-components DEPENDENCY -->
            <dependency>
                <groupId>io.github.astrapi69</groupId>
                <artifactId>swing-model-components</artifactId>
                <version>${swing-model-components.version}</version>
            </dependency>
            ...
        </dependencies>

## Support this project

If swing-model-components is useful to you, a star on [GitHub](https://github.com/astrapi69/swing-model-components) helps others find it.
Sharing it or reporting a bug helps just as much.

If you would like to contribute financially, the channels are on the repository's Sponsor button, which
reads [.github/FUNDING.yml](.github/FUNDING.yml): GitHub Sponsors, Liberapay, Ko-fi and PayPal.

## Semantic Versioning

The versions of swing-model-components are maintained with the Semantic Versioning guidelines.

Release version numbers will be incremented in the following format:

`<major>.<minor>.<patch>`

For detailed information on versioning you can visit the [wiki page](https://github.com/lightblueseas/mvn-parent-projects/wiki/Semantic-Versioning).

## What can i do to support this project

You can donate or contribute solve issues or pull request. Every support are welcome.

## Want to Help and improve it? ###

The source code for swing-model-components are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [astrapi69/swing-model-components/fork](https://github.com/astrapi69/swing-model-components/fork)

To share your changes, [submit a pull request](https://github.com/astrapi69/swing-model-components/pull/new/develop).

Don't forget to add new units tests on your changes.

## Contacting the Developers

Do not hesitate to contact the swing-model-components developers with your questions, concerns, comments, bug reports, or feature requests.
- Feature requests, questions and bug reports can be reported at the [issues page](https://github.com/astrapi69/swing-model-components/issues).

## Similar projects

## Credits
