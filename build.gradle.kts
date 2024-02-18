plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.application") version "4.3.2"
    id("io.micronaut.test-resources") version "4.3.2"
    id("io.micronaut.aot") version "4.3.2"
}

version = "0.1"
group = "com.ngfds"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("io.micronaut:micronaut-http-validation")
    annotationProcessor("io.micronaut.serde:micronaut-serde-processor")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("io.micronaut.data:micronaut-data-model:4.6.1")
    implementation("io.micronaut.data:micronaut-data-jdbc:4.6.1")
    implementation("io.micronaut.flyway:micronaut-flyway")
    compileOnly("io.micronaut:micronaut-http-client")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("io.micronaut:micronaut-http-client")
}


application {
    mainClass.set("com.ngfds.Application")
}

java {
    sourceCompatibility = JavaVersion.toVersion("17")
    targetCompatibility = JavaVersion.toVersion("17")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.ngfds.Application"
    }
}


graalvmNative.toolchainDetection.set(false)
micronaut {
    version = "4.3.2"
    runtime("tomcat")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.ngfds.*")
    }
    testResources {
        additionalModules.add("jdbc-postgresql")
    }
    aot {
        // Please review carefully the optimizations enabled below
        // Check https://micronaut-projects.github.io/micronaut-aot/latest/guide/ for more details
        optimizeServiceLoading.set(false)
        convertYamlToJava.set(false)
        precomputeOperations.set(true)
        cacheEnvironment.set(true)
        optimizeClassLoading.set(true)
        deduceEnvironment.set(true)
        optimizeNetty.set(true)
    }
}



