@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.mymoneymateAndroidLibraryCompose)
    alias(libs.plugins.mymoneymateAndroidLibrary)
    alias(libs.plugins.mymoneymateFeaturePresentation)
}

android {
    namespace = "com.vn.mywallet"
}

dependencies {
    implementation(projects.shared)
}
