package com.vn.mymoneymate

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures.compose = true
        composeOptions.kotlinCompilerExtensionVersion =
            libs.findVersion("compose-compiler").get().toString()

        dependencies {
            add("implementation", libs.findLibrary("compose-ui").get())
            add("implementation", libs.findLibrary("compose-nav").get())
            add(
                "implementation",
                libs.findLibrary("compose-ui-tooling-preview").get()
            )
            add(
                "implementation",
                libs.findLibrary("compose-material3").get()
            )
        }
    }
}