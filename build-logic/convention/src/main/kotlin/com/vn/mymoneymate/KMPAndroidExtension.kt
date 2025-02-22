package com.vn.mymoneymate

import com.android.build.gradle.LibraryExtension

internal fun configureKMPAndroidExtension(
    extension: LibraryExtension
) {
    extension.apply {
        namespace = "com.vn.mymoneymate"
        compileSdk = 34
        defaultConfig {
            minSdk = 26
        }
    }
}