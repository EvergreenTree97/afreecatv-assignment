plugins {
    `java-library`
    id("kotlin")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = Apps.sourceCompat
    targetCompatibility = Apps.targetCompat
}

dependencies {
    kapt(Dependencies.Hilt.Kapt)
    implementation(Dependencies.Hilt.Core)
    implementation(Dependencies.Paging.Common)
    Dependencies.Essential.forEach(::implementation)
    Dependencies.Test.forEach(::testImplementation)
}