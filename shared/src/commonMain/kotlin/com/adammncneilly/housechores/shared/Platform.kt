package com.adammncneilly.housechores.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
