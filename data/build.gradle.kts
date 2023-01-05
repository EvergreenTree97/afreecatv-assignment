import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "com.sangrok.data"
    compileSdk = Apps.compileSdk
    defaultConfig{
        //buildConfigField("String", "API_URL", "\"http://api-dev.semonemo.xyz/\"")
    }
}

dependencies {
    kapt(Dependencies.Hilt.Kapt)
    implementation(project(Modules.Domain))
    implementation(Dependencies.Hilt.Android)
    Dependencies.Test.forEach(::testImplementation)
    Dependencies.Essential.forEach(::implementation)
    Dependencies.Network.forEach(::implementation)
}