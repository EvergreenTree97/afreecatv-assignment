plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}
android {
    namespace = "com.sangrok.domain"
    compileSdk = Apps.compileSdk
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