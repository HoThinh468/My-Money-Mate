plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

gradlePlugin {
    plugins {
        register("androidLibrary") {
            id = "mymoneymate.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "mymoneymate.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "mymoneymate.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "mymoneymate.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidFeaturePresentation") {
            id = "mymoneymate.android.feature.presentation"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("myMoneyMateKMP") {
            id = "mymoneymate.kmp"
            implementationClass = "KMPPlugin"
        }
    }
}