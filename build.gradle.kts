import org.gradle.script.lang.kotlin.extra


buildscript {
    val springBootVersion: String = "1.5.2.RELEASE"
    val kotlinVersion: String = "1.1.1"

    extra["kotlinVersion"] = kotlinVersion
    extra["springBootVersion"] = springBootVersion


    repositories {
        gradleScriptKotlin()
        mavenCentral()
    }

    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
//        classpath("org.jetbrains.kotlin:kotlin-noarg:$kotlinVersion") // Es müssen keine zero-args constructors defieniert werden
        classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion") // Klassen müssen nicht als open deklariert werden
        classpath("org.asciidoctor:asciidoctor-gradle-plugin:1.5.3")
    }
}

apply {
    plugin("kotlin")
    plugin("kotlin-spring")
//    plugin("kotlin-jpa")
    plugin("org.springframework.boot")
    plugin("org.asciidoctor.convert")
}

configure<JavaPluginConvention> {
    setSourceCompatibility(1.8)
    setTargetCompatibility(1.8)
}

repositories {
    mavenCentral()
}

val springBootVerison = extra["springBootVersion"] as String
val kotlinVersion = extra["kotlinVersion"] as String

dependencies {
    compile("org.springframework.boot:spring-boot-starter-web:$springBootVerison")
    compile("org.springframework.boot:spring-boot-starter-data-jpa:$springBootVerison")
    compile("com.h2database:h2")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.8.7")
    compile("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    compile("org.springframework.restdocs:spring-restdocs-restassured:1.1.2.RELEASE")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}

