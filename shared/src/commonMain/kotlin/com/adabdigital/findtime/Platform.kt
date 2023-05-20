package com.adabdigital.findtime

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform