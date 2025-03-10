plugins {
    id("com.android.application")
    id("kotlin-android")
    // The Flutter Gradle Plugin must be applied after the Android and Kotlin Gradle plugins.
    id("dev.flutter.flutter-gradle-plugin")
    id("com.google.gms.google-services")

    
}

android {
    namespace = "com.example.application"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = "27.0.12077973"
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    defaultConfig {
    applicationId = "com.example.application"

    // Correct way to set minSdkVersion in Kotlin DSL
    minSdkVersion(23)

    // Correct way to set targetSdkVersion in Kotlin DSL
    targetSdkVersion(flutter.targetSdkVersion)

    versionCode = flutter.versionCode
    versionName = flutter.versionName
}

    buildTypes {
        release {
            // TODO: Add your own signing config for the release build.
            // Signing with the debug keys for now, so `flutter run --release` works.
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

flutter {
    source = "../.."
}

dependencies {
    // implementation("com.google.firebase:firebase-auth-ktx:22.3.1")
    // implementation("com.google.firebase:firebase-firestore-ktx:24.9.1")
    // implementation("com.google.firebase:firebase-analytics-ktx:21.6.1")
    implementation(platform("com.google.firebase:firebase-bom:33.10.0"))
    implementation("com.google.firebase:firebase-analytics")
}