package com.vn.mymoneymate

import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal fun Project.configureKMPExtension(
    kmpExtension: KotlinMultiplatformExtension
) {
    kmpExtension.apply {
        androidTarget {
            compilations.all {
                kotlinOptions {
                    jvmTarget = JavaVersion.VERSION_17.toString()
                }
            }
            jvmToolchain(17)
        }

        listOf(
            iosX64(),
            iosArm64(),
            iosSimulatorArm64()
        ).forEach {
            it.binaries.framework {
                baseName = "shared"
                isStatic = true
            }
        }

        // Common dependencies
        sourceSets.apply {
            getByName("commonMain").dependencies {
                // Add your common dependencies here
            }
            getByName("commonTest").dependencies {
                implementation(libs.findLibrary("kotlin-test").get())
            }
        }
    }
}