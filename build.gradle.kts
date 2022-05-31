import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.Properties

plugins {
    id("org.springframework.boot") version "2.6.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
    id("com.bmuschko.docker-spring-boot-application") version "7.3.0"
    id("com.palantir.git-version") version "0.13.0"
}

group = "com.whu.se2022.qiaqia"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

val gitDetails = run {
    val versionDetails: groovy.lang.Closure<com.palantir.gradle.gitversion.VersionDetails> by extra
    versionDetails()
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2")
    implementation("com.baomidou:mybatis-plus-boot-starter:3.5.1")
    implementation("mysql:mysql-connector-java:8.0.29")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("com.auth0:java-jwt:3.19.1")
    implementation("com.networknt:exception:2.1.1")
    implementation("com.alibaba:fastjson:1.2.79")
    implementation("org.springframework.security:spring-security-web")
    implementation("org.springframework.security:spring-security-config")
    compileOnly("org.projectlombok:lombok")
    compileOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")

    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.2.2")

    implementation("org.postgresql:postgresql:42.3.3")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

docker {
    val dockerProperties = Properties().apply {
        val propertiesFile = rootProject.file("gradle-docker.properties")
        if (propertiesFile.exists())
            load(propertiesFile.inputStream())
        this.putAll(System.getProperties())
    }
    val dockerRegistryUrl = dockerProperties.getProperty("docker.registry.url")
    val dockerRegistryUsername = dockerProperties.getProperty("docker.registry.username")
    val dockerRegistryPassword = dockerProperties.getProperty("docker.registry.password")
    val dockerImageName = dockerProperties.getProperty("docker.image.name.backend")

    dockerProperties.getProperty("docker.remote.api.address")?.let { url.set(it) }
    springBootApplication {
        baseImage.set("openjdk:11")
        images.addAll("$dockerImageName:nightly", "$dockerImageName:${gitDetails.gitHash}")
        jvmArgs.set(listOf("-Dspring.profiles.active=prod"))
    }
    registryCredentials {
        url.set(dockerRegistryUrl)
        username.set(dockerRegistryUsername)
        password.set(dockerRegistryPassword)
    }
}