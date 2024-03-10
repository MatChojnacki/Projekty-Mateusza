plugins {
    id("java")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // https://mvnrepository.com/artifact/org.mockito/mockito-core
    testImplementation ("org.mockito:mockito-core:2.1.0")
    // https://mvnrepository.com/artifact/mysql/mysql-connector-java
    implementation ("mysql:mysql-connector-java:8.0.33")


}

tasks.test {
    useJUnitPlatform()
}