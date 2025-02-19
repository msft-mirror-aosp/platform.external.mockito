#!/bin/bash

# $1 Path to the new version.
# $2 Path to the old version.

excludes=(
.checkstyle
.editorconfig
.gitattributes
.github/
.gitignore
README.md
SECURITY.md
check_reproducibility.sh
config/
doc/
gradle.properties
gradle/
gradlew
gradlew.bat
src/conf/
src/javadoc/
subprojects/androidTest/
subprojects/deprecatedPluginsTest/
subprojects/errorprone/
subprojects/extTest/
subprojects/groovyTest/
subprojects/junit-jupiter/
subprojects/junitJupiterExtensionTest/
subprojects/junitJupiterInlineMockMakerExtensionTest/
subprojects/junitJupiterParallelTest/
subprojects/kotlinReleaseCoroutinesTest/
subprojects/kotlinTest/
subprojects/memory-test/
subprojects/module-test/
subprojects/osgi-test/
)

for remove in ${excludes[@]}; do
  rm -rf "$1/$remove"
done
