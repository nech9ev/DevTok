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

        testInstrumentationRunner = "com.nech9ev.data.CustomTestRunner"
    }

    buildTypes {

        getByName("release")

        getByName("debug")

    }

}

dependencies {
    implementation(project(":domain"))

    kapt("com.google.dagger:hilt-android:2.40.5")
    kapt("com.google.dagger:hilt-android-compiler:2.40.5")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    api("androidx.hilt:hilt-compiler:1.0.0")
    api("com.google.dagger:hilt-android:2.40.5")
    api("com.google.dagger:hilt-android:2.40.5")
    api("com.google.dagger:hilt-android-compiler:2.40.5")
    implementation("io.ktor:ktor-client-okhttp:1.6.7")
    implementation("io.ktor:ktor-client-serialization:1.6.7")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.4")

    testImplementation ("junit:junit:4.13.2")
    testImplementation ("com.google.truth:truth:1.1.3")

    androidTestImplementation ("org.mockito:mockito-core:4.2.0")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.40.5")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.40.5")
    androidTestImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    androidTestImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0")
    androidTestImplementation ("junit:junit:+")
    androidTestImplementation("org.mockito:mockito-android:4.2.0")
}

kapt{
    correctErrorTypes = true
}