package com.yoesuv.kmpswitchtheme

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform