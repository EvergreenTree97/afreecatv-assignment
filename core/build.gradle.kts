plugins {
    id("com.android.library")
    id("kotlin-android")
}
android {
    compileSdk = Apps.compileSdk
    namespace = "com.sangrok.core"
    defaultConfig {
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk
    }

    compileOptions {
        sourceCompatibility = Apps.sourceCompat
        targetCompatibility = Apps.targetCompat
    }

    kotlinOptions {
        jvmTarget = Apps.jvmTarget

    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compiler.Compose
    }
}

dependencies {
    Dependencies.Essential.forEach(::implementation)
    Dependencies.Compose.forEach(::implementation)
    Dependencies.Ktx.forEach(::implementation)
}