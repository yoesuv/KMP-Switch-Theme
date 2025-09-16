package com.yoesuv.kmpswitchtheme.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kmpswitchtheme.composeapp.generated.resources.Res
import kmpswitchtheme.composeapp.generated.resources.app_dark_mode
import kmpswitchtheme.composeapp.generated.resources.exit
import kmpswitchtheme.composeapp.generated.resources.information
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomeScreen(innerPadding: PaddingValues, isDark: Boolean) {
    val viewModel = viewModel { HomeViewModel(initialIsDark = isDark) }
    val isDarkModeEnabled by viewModel.isDarkModeEnabled.collectAsState()

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(horizontal = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(stringResource(Res.string.information))
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(stringResource(Res.string.app_dark_mode))
            Switch(
                checked = isDarkModeEnabled,
                onCheckedChange = { enabled ->
                    viewModel.onDarkModeToggle(enabled)
                }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                stringResource(Res.string.exit), style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                )
            )
        }
    }
}