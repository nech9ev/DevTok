plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlinx-serialization")
    id("dagger.hilt.android.plugin")
}

android {

    compileSdk = 32

    defaultConfig {

        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {

        getByName("release")

        getByName("debug")

    }

}

dependencies {
    implementation(project(":core"))
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    implementation("androidx.hilt:hilt-compiler:1.0.0")
    implementation("com.google.dagger:hilt-android:2.40.5")
    kapt("com.google.dagger:hilt-android:2.40.5")
    kapt("com.google.dagger:hilt-android-compiler:2.40.5")
    api("io.ktor:ktor-client-okhttp:1.6.7")
    implementation("io.ktor:ktor-client-serialization:1.6.7")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.4")

    testImplementation ("junit:junit:4.13.2")
}

kapt{
    correctErrorTypes = true
}