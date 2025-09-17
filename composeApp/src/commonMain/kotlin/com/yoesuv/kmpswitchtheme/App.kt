package com.yoesuv.kmpswitchtheme

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yoesuv.kmpswitchtheme.core.route.AppRoute
import com.yoesuv.kmpswitchtheme.core.theme.DarkScheme
import com.yoesuv.kmpswitchtheme.core.theme.LightScheme
import com.yoesuv.kmpswitchtheme.feature.home.HomeScreen
import kmpswitchtheme.composeapp.generated.resources.Res
import kmpswitchtheme.composeapp.generated.resources.app_name
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    // Initialize theme from saved preferences
    initializeTheme()
    
    AppEnvironment {
        val isDark = LocalAppTheme.current
        MaterialTheme(colorScheme = if (isDark) DarkScheme else LightScheme) {
            val navController = rememberNavController()
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(stringResource(Res.string.app_name)) }
                    )
                }
            ) { innerPadding ->
                NavHost(navController = navController, startDestination = AppRoute.Home) {
                    composable<AppRoute.Home> {
                        HomeScreen(innerPadding = innerPadding, isDark = isDark)
                    }
                }
            }
        }
    }
}