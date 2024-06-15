plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.basiccalculator"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.basiccalculator"
        minSdk = 28
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("org.mozilla:rhino:1.7.11")
    implementation("androidx.databinding:compiler:3.2.0-alpha11")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Exclude listenablefuture from guava to resolve conflict
    implementation("com.google.guava:guava:30.1-jre") {
        exclude(group = "com.google.guava", module = "failureaccess")
        exclude(group = "com.google.guava", module = "listenablefuture")
    }
}
