plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-parcelize")
}

android {
    namespace = "com.developer.dealslist"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.developer.dealslist"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val nav_version = "2.7.5"
    val compose_version = "1.6.0-alpha08"
    val retrofit_version = "2.9.0"
    val lifecycle_version = "2.6.2"
    val material3_version = "material3-android:1.2.0-rc01"
    val coil_version = "coil-compose:2.4.0"

    // To use the androidx.test.core APIs
//    androidTestImplementation("androidx.test:core:1.6.1")
//    androidTestImplementation("androidx.test:core:1.6.0")
//    androidTestImplementation("androidx.test:core:1.5.0")
//    // Kotlin extensions for androidx.test.core
//    androidTestImplementation("androidx.test:core-ktx:1.6.1")
//
//    // To use the androidx.test.espresso
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
//
//    // To use the JUnit Extension APIs
//    androidTestImplementation("androidx.test.ext:junit:1.2.1")
//    // Kotlin extensions for androidx.test.ext.junit
//    androidTestImplementation("androidx.test.ext:junit-ktx:1.2.1")
//
//    // To use the Truth Extension APIs
//    androidTestImplementation("androidx.test.ext:truth:1.6.0")
//
//    // To use the androidx.test.runner APIs
//    androidTestImplementation("androidx.test:runner:1.6.2")
//    androidTestImplementation("androidx.test:runner:1.6.1")

    // To use android test orchestrator
//    androidTestUtil("androidx.test:orchestrator:1.5.1")

//    debugImplementation("androidx.compose.ui:ui-test-manifest:$compose_version")
//    implementation("androidx.compose.ui:ui-test-junit4:$compose_version")
//    implementation("androidx.compose.ui:ui:$compose_version")
//    implementation("androidx.compose.ui:ui-tooling:$compose_version")
//    testImplementation("junit:junit:4.+")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.ext:junit:1.5.0")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")

    testImplementation("org.mockito:mockito-core:4.7.0")
    testImplementation("org.mockito:mockito-android:4.7.0")

    implementation("androidx.navigation:navigation-compose:$nav_version")
    implementation("androidx.compose.ui:ui:$compose_version")
    implementation("androidx.compose.material:material:$compose_version")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version") //compose viewmodel
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version") //retrofit network calls
    implementation("com.squareup.retrofit2:converter-gson:$retrofit_version") //json -> obj mapping
    implementation("androidx.compose.material3:$material3_version")

    implementation("io.coil-kt:$coil_version")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}