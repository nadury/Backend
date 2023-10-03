import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    kotlin("plugin.spring") version "1.4.32" apply false
    kotlin("plugin.jpa") version "1.4.32" apply false
    kotlin("plugin.lombok") version "1.7.10" apply false
    id("io.freefair.lombok") version "8.1.0" apply false
    id("org.springframework.boot") version "2.7.9" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false

}

allprojects{
    group = "org.example"
    version = "1.0-SNAPSHOT"

    repositories {
       // jcenter()
        mavenCentral()
    }

    /*tasks.test {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }*/
}



subprojects{
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "org.jetbrains.kotlin.plugin.jpa")
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-kapt")
    apply(plugin = "org.jetbrains.kotlin.plugin.lombok")
    apply(plugin = "io.freefair.lombok")

    dependencies {


        //implementation("org.springframework.boot:spring-boot-starter-web")
        //implementation("org.springframework.boot:spring-boot-starter-mustache")
        runtimeOnly("org.springframework.boot:spring-boot-devtools")

        // db
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        //runtimeOnly("com.mysql:mysql-connector-j")

        // util
        //compileOnly ("org.projectlombok:lombok")
        //annotationProcessor ("org.projectlombok:lombok")
        implementation("org.jetbrains.kotlin:kotlin-reflect")

        // test
        testImplementation(kotlin("test"))
    }

/*    kapt {
        keepJavacAnnotationProcessors = true
    }*/

    tasks.test {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

}



