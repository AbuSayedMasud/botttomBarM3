package com.example.botttombarm3

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyFloatingActionButton(onClick: () -> Unit) {
    // Define your floating action button here
    FloatingActionButton(
        onClick = onClick,
        modifier = Modifier
            .size(100.dp) // Customize the size as needed
            .offset(x = (-32).dp) // Customize the padding as needed
    ) {
        // Your FAB content here, e.g., an icon
        Icon(Icons.Default.Add, contentDescription = null)
    }
}