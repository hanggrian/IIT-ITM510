val RELEASE_GROUP: String by project

plugins {
    java
    alias(libs.plugins.javafx)
    application
    checkstyle
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(libs.versions.jdk.get()))

javafx.modules("javafx.controls", "javafx.fxml")

application.mainClass.set("$RELEASE_GROUP.App")

checkstyle {
    toolVersion = libs.versions.checkstyle.get()
    configFile = rootDir.resolve("rulebook_checks.xml")
}

dependencies {
    checkstyle(libs.checkstyle)
    checkstyle(libs.rulebook.checkstyle)

    testImplementation(libs.truth)
}
