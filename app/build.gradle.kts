
plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    namespace = "com.lolinet.unicornfantasian"
    compileSdk = 33
    buildToolsVersion("33.0.0")
    defaultConfig {
        applicationId = "com.lolinet.unicornfantasian"
        minSdk = 25
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        
        vectorDrawables { 
            useSupportLibrary = true
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    
   signingConfigs {
        create("release") {
            storeFile = file("signing-key.jks")
            storePassword = ""
            keyAlias = ""
            keyPassword = ""
        }
    }

   buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            signingConfig = signingConfigs.getByName("release")
        }
    }

    buildFeatures {
        viewBinding = true
        
    }
    
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "11"
}

dependencies {


    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.webkit:webkit:1.7.0")
}
