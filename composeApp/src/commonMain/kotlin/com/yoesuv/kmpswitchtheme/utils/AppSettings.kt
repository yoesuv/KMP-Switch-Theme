package com.yoesuv.kmpswitchtheme.utils
import com.russhwolf.settings.Settings
import com.russhwolf.settings.get
import com.russhwolf.settings.set

object AppSettings {
    private val settings: Settings = Settings() // SharedPreferences on Android, NSUserDefaults on iOS

    private const val KEY_THEME = "key_theme"

    fun saveThemeState(isEnabled: Boolean) {
        settings[KEY_THEME] = isEnabled
    }

    fun getThemeState(default: Boolean = false): Boolean {
        return settings[KEY_THEME, default]
    }
}