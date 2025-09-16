package com.yoesuv.kmpswitchtheme.core.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val LightScheme = lightColorScheme(
    primary = AppColor.teal,
    onPrimary = Color.White,
    surface = AppColor.greyf6,
    background = AppColor.greyf6
)

val DarkScheme = darkColorScheme(
    primary = AppColor.teal,
    onPrimary = Color.White,
    surface = AppColor.reversedGrey,
    background = AppColor.reversedGrey,
)
