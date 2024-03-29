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
    implementation(projects.shared)
    implementation(libs.androidx.activity.compose)

    // features
    implementation(projects.features.mywallet)
    implementation(projects.features.budgets)

}