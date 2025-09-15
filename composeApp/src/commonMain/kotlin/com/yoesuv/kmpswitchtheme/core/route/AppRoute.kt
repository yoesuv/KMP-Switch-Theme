package com.yoesuv.kmpswitchtheme.core.route

import kotlinx.serialization.Serializable

sealed class AppRoute {
    @Serializable
    data object Home : AppRoute()
}