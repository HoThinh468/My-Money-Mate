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
    // share sections
    implementation(projects.shared.core)

    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.foundation)
    implementation(libs.compose.nav)
    implementation(libs.compose.material3)
    implementation(libs.compose.constraint.layout)
}