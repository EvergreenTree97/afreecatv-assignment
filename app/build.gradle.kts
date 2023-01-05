plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}
android {
    compileSdk = Apps.compileSdk
    namespace = "com.sangrok.app"
    defaultConfig {
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk
        versionCode = Apps.versionCode
        versionName = Apps.versionName
    }

    compileOptions {
        sourceCompatibility = Apps.sourceCompat
        targetCompatibility = Apps.targetCompat
    }

    kotlinOptions {
        jvmTarget = Apps.jvmTarget

    }
}

dependencies {
    implementation(project(Modules.Presentation))
    implementation(project(Modules.Data))
    implementation(project(Modules.Domain))

    kapt(Dependencies.Hilt.Kapt)
    implementation(Dependencies.Hilt.Android)
}