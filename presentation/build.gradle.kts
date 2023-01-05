plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Apps.compileSdk
    namespace = "com.sangrok.presentation"

    buildTypes {
        debug {

        }
        release {

        }
    }

    compileOptions {
        sourceCompatibility = Apps.sourceCompat
        targetCompatibility = Apps.targetCompat
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compiler.Compose
    }

    kotlinOptions {
        jvmTarget = Apps.jvmTarget
    }
}
dependencies {
    kapt(Dependencies.Hilt.Kapt)
    implementation(project(Modules.Domain))
    implementation(Dependencies.Hilt.Android)
    Dependencies.Essential.forEach(::implementation)
    Dependencies.Compose.forEach(::implementation)
    Dependencies.Ktx.forEach(::implementation)
}
