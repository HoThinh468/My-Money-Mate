package com.vn.mymoneymate

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform