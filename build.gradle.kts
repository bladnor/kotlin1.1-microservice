buildscript {

    repositories {
        gradleScriptKotlin()
        mavenCentral()
    }

    dependencies {
        classpath(kotlinModule("gradle-plugin"))
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.0-M3")
    }
}

apply {
    plugin("kotlin")
    plugin("org.junit.platform.gradle.plugin")
}


repositories {
    gradleScriptKotlin()
}

dependencies {
    compile(kotlinModule("stdlib","1.1.1"))
    testCompile("org.junit.jupiter:junit-jupiter-api:5.0.0-M3")
    testCompile("org.junit.jupiter:junit-jupiter-engine:5.0.0-M3")
}