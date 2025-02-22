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
include(":core")
include(":core:designsystem")
include(":core:utility")
include(":features:mywallet")
include(":features:budgets")
include(":features:report")
include(":shared:core")
include(":shared:mywallet")
