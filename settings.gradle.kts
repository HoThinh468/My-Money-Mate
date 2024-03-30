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
include(":core")
include(":core:designsystem")
include(":features:mywallet")
include(":features:budgets")
include(":features:report")
