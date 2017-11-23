import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.repositories
import org.gradle.kotlin.dsl.version
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.tasks.wrapper.Wrapper

plugins {
    application
    kotlin("jvm") version "1.1.60"
}

dependencies {
    compile(kotlin("stdlib"))
    compile("com.github.qwertukg:SeleniumBuilder:b08536ffff")
    compile("no.tornado:tornadofx:1.7.12")
}

application {
    mainClassName = "demo.HelloWorldKt"
}

repositories {
    jcenter()
    maven("https://jitpack.io")
}


tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

task(name = "wrapper", type = Wrapper::class) {
    gradleVersion = "4.3"
    distributionUrl = "http://services.gradle.org/distributions/gradle-$gradleVersion-bin.zip"
}