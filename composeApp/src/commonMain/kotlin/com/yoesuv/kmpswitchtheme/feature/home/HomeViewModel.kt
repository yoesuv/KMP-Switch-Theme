package com.yoesuv.kmpswitchtheme.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _isDarkModeEnabled = MutableStateFlow(true)
    val isDarkModeEnabled: StateFlow<Boolean> = _isDarkModeEnabled.asStateFlow()

    fun onDarkModeToggle(enabled: Boolean) {
        viewModelScope.launch {
            _isDarkModeEnabled.value = enabled
        }
    }
}
