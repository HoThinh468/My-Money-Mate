enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "My_Money_Mate"
include(":androidApp")
include(":shared")
include(":features:mywallet")
include(":features:budgets")
include(":core")
include(":core:designsystem")
