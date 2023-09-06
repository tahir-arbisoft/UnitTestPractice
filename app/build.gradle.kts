plugins {
//    id("kotlin-kapt")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.unittestpracticing"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.unittestpracticing"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    testImplementation("junit:junit:4.12")
    testImplementation("androidx.test:core:1.5.0-rc01")
    testImplementation("androidx.test:core-ktx:1.5.0-rc01")
    androidTestImplementation("androidx.test.ext:junit:1.1.4-rc01")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.4-rc01")
    androidTestImplementation("androidx.test:runner:1.5.0-rc01")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test.espresso:espresso-intents:3.5.1")

    testImplementation("androidx.arch.core:core-testing:2.2.0")
    androidTestImplementation("androidx.arch.core:core-testing:2.2.0")

    val roomVersion = "2.5.2"
    implementation("androidx.room:room-runtime:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")

    testImplementation("androidx.room:room-testing:$roomVersion")
    androidTestImplementation("androidx.room:room-testing:$roomVersion")

    // Optional -- Mockito framework
    testImplementation("org.mockito:mockito-core:5.2.0")
    // Optional -- mockito-kotlin
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")

    // lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

    // coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.0")

    // retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.7.2")
    implementation("com.google.code.gson:gson:2.10.1")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.9.0")
}