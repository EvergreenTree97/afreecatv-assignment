object Dependencies {

    val Essential = listOf(
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Essential.Coroutines}",
    )

    object Kotlin {
        const val ImmutableCollections = "org.jetbrains.kotlinx:kotlinx-collections-immutable:${Versions.Essential.ImmutableCollections}"
    }

    object Hilt {
        const val Core = "com.google.dagger:hilt-core:${Versions.Jetpack.Hilt}"
        const val Android = "com.google.dagger:hilt-android:${Versions.Jetpack.Hilt}"
        const val Kapt = "com.google.dagger:hilt-android-compiler:${Versions.Jetpack.Hilt}"
    }

    object Paging {
        const val Runtime = "androidx.paging:paging-runtime:${Versions.Jetpack.Paging}"
        const val Common = "androidx.paging:paging-common:${Versions.Jetpack.Paging}"
    }


    val Ktx = listOf(
        "androidx.core:core-ktx:${Versions.Ktx.Core}",
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Ktx.LifeCycle}",
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Ktx.ViewModel}",
    )

    val Network = listOf(
        "com.squareup.retrofit2:retrofit:${Versions.Network.Retrofit}",
        "com.squareup.okhttp3:logging-interceptor:${Versions.Network.OkHttp}",
        "com.squareup.okhttp3:okhttp:${Versions.Network.OkHttp}",
        "com.squareup.retrofit2:converter-gson:${Versions.Network.Retrofit}"
    )

    val Compose = listOf(
        "androidx.compose.material:material:${Versions.Compose.Material}",
        "androidx.compose.ui:ui:${Versions.Compose.Main}",
        "androidx.compose.runtime:runtime:${Versions.Compose.Main}",
        "androidx.compose.foundation:foundation:${Versions.Compose.Main}",
        "androidx.activity:activity-compose:${Versions.Compose.Activity}",
        "com.google.accompanist:accompanist-swiperefresh:${Versions.Compose.Accompanist}",
        "com.google.accompanist:accompanist-systemuicontroller:${Versions.Compose.Accompanist}",
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Compose.LifecycleViewModel}",
        "io.coil-kt:coil-compose:${Versions.Compose.Coil}",
        "com.google.accompanist:accompanist-pager:${Versions.Compose.Accompanist}",
        "com.google.accompanist:accompanist-pager-indicators:${Versions.Compose.Accompanist}",
        "androidx.paging:paging-compose:${Versions.Compose.Paging}",
    )
    val Test = listOf(
        "junit:junit:${Versions.Test.JUnit}",
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Test.Coroutine}",
        "io.mockk:mockk:${Versions.Test.Mockk}"
    )
}