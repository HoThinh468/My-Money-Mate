plugins {
    alias(libs.plugins.mymoneymateAndroidApplication)
    alias(libs.plugins.mymoneymateAndroidApplicationCompose)
}

android {
    namespace = "com.vn.mymoneymate.android"
    defaultConfig {
        applicationId = "com.vn.mymoneymate.android"
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    // Shared & common
    implementation(projects.shared)
    implementation(projects.core.designsystem)

    // features
    implementation(projects.features.mywallet)
    implementation(projects.features.budgets)
    implementation(projects.features.report)
}