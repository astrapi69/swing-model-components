## Change log
----------------------

Version 1.2-SNAPSHOT
-------------

ADDED:

- new Makefile with build, test, release and publish targets
- new license header file src/main/resources/license-header.txt for the spotless licenseHeaderFile step
- new headless unit tests for the model binding of JMComboBox, JMTextField, JMCheckBox, JMBigDecimalTextField and JMBigIntegerTextField that also run in CI
- new publishing repository configuration for the Central Portal (releases over the OSSRH staging API, snapshots to central.sonatype.com) with credentials from CENTRAL_USERNAME/CENTRAL_PASSWORD or the gradle properties centralUsername/centralPassword
- new gradle file tagging.gradle with the tagRelease task based on a plain git Exec task

FIXED:

- JMCheckBox threw a RuntimeException on every selection change because the PropertyModel expression 'model.selected' could not resolve the inherited getModel method; the property model is now a BaseModel that is synchronized in the item listener
- the javadoc task excluded all classes and produced an empty javadoc jar

CHANGED:

- interactive demo classes renamed from *Test to *Demo so that only real unit tests are discovered by the test engine
- removed unused test dependencies commons-text, gradle-migration-data, silly-io, file-worker and meanbean
- removed the grgit gradle plugin; the tagRelease task now uses a plain git Exec task, so the gradle configuration cache works without workarounds
- new gradle plugin org.gradle.toolchains.foojay-resolver-convention in version 1.0.0 for automatic JDK provisioning
- Makefile no longer hardcodes JAVA_HOME
- github-actions workflow: removed obsolete ossrh secrets, updated setup-gradle to v4 and codecov-action to v5
- removed obsolete HELP.md template file

- migrate publishing to Central Portal (snapshots to central.sonatype.com, signing with in-memory GPG keys from environment variables)
- update gradle to new version 9.7.0
- remove of license-gradle-plugin, license headers are now managed by the spotless licenseHeaderFile step
- update of gradle-plugin dependency 'io.freefair.lombok' to new version 9.5.0
- update of gradle-plugin dependency 'com.diffplug.spotless:spotless-plugin-gradle' to new version 8.10.0
- update of gradle-plugin dependency of io.github.ben-manes.versions to new version 0.61.0
- update of gradle-plugin dependency 'org.ajoberstar.grgit' to new version 5.3.3
- update of gradle-plugin dependency 'nl.littlerobots.version-catalog-update' to new version 1.1.1
- update of dependency lombok to new version 1.18.46
- update of dependency swing-base-components to new major version 5.1
- update of dependency menu-action to new major version 4.1
- update of test dependency awt-extensions to new major version 2.0
- update of test dependency file-worker to new version 19.0
- update of test dependency silly-collection to new version 28.1
- update of test dependency silly-io to new version 3.6
- update of test dependency miglayout-swing to new version 11.4.3
- update of test dependency junit-jupiter to new major version 6.1.3
- dependencies are now organized in bundles in the version catalog

Version 1.1
-------------

ADDED:

- new JMGenericTextField with data type BigInteger
- new JMGenericTextField with data type BigDecimal
- new libs.versions.toml file for new automatic catalog versions update

CHANGED:

- update gradle to new version 8.9
- update of dependency lombok to new version 1.18.34
- update gradle-plugin dependency of com.github.ben-manes:gradle-versions-plugin to new version 0.51.0
- update of gradle-plugin dependency 'com.diffplug.spotless:spotless-plugin-gradle' to new minor version 7.0.0.BETA1
- update of test dependency junit-jupiter-api to new version 5.11.0-M1
- all component class implement all constructors from super class for compatibility
- improve of javadoc

Version 1
-------------
*
*ADDED:

- new CHANGELOG.md file created

Notable links:
[keep a changelog](http://keepachangelog.com/en/1.0.0/) Don’t let your friends dump git logs into changelogs
