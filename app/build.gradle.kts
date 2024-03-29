plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.appnat3.tutoratplus"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.appnat3.tutoratplus"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures{
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    implementation("com.squareup.okhttp3:okhttp")
    implementation("org.json:json:20231013")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito.kotlin:mockito-kotlin:5.1.0")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation ("org.mockito:mockito-core:3.3.3")
    testImplementation ("com.squareup.okhttp3:mockwebserver:4.9.0")
    testImplementation ("org.robolectric:robolectric:4.5.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation ("androidx.navigation:navigation-ui-ktx:2.5.3")

    //dependence Calendrier
    implementation("com.google.api-client:google-api-client-android:1.23.0"){
        exclude("org.apache.httpcomponents")
        exclude("com.google.guava")
    }
    implementation("com.google.apis:google-api-services-calendar:v3-rev305-1.23.0"){
        exclude("com.google.guava")
    }
    implementation("com.google.oauth-client:google-oauth-client-jetty:1.23.0")




}