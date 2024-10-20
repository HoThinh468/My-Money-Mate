plugins {
    alias(libs.plugins.mymoneymateAndroidLibrary)
}

android {
    namespace = "com.vn.utility"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}
