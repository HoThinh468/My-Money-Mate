plugins {
    alias(libs.plugins.mymoneymateAndroidLibrary)
    alias(libs.plugins.mymoneymateAndroidLibraryCompose)
}

android {
    namespace = "com.vn.designsystem"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(libs.compose.ui)
    implementation(libs.compose.foundation)
    implementation(libs.compose.nav)
    implementation(libs.compose.material3)
}