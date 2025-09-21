package com.yoesuv.kmpswitchtheme.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yoesuv.kmpswitchtheme.customAppThemeIsDark
import com.yoesuv.kmpswitchtheme.setStatusBarLightIcons
import com.yoesuv.kmpswitchtheme.utils.AppSettings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    initialIsDark: Boolean
) : ViewModel() {
    private val _isDarkModeEnabled = MutableStateFlow(initialIsDark)
    val isDarkModeEnabled: StateFlow<Boolean> = _isDarkModeEnabled.asStateFlow()

    fun onDarkModeToggle(enabled: Boolean) {
        viewModelScope.launch {
            _isDarkModeEnabled.value = enabled
            // Save the theme preference to persistent storage
            AppSettings.saveThemeState(enabled)
            // Propagate the change to the app theme so MaterialTheme updates
            customAppThemeIsDark = enabled
            // Update status bar light icons based on theme
            // Light icons for dark theme (enabled = true), dark icons for light theme (enabled = false)
            setStatusBarLightIcons(!enabled)
        }
    }
}
