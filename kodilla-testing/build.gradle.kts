plugins {
    id("java")
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.testng:testng:7.1.0")
    implementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation("junit:junit:4.13.1")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    // https://mvnrepository.com/artifact/org.mockito/mockito-junit-jupiter
    testImplementation ("org.mockito:mockito-junit-jupiter:5.8.0")

}

tasks.test {
    useJUnitPlatform()
}