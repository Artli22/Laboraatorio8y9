package com.limaa.lab9moviles.ui.Components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.People
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavDestination {
    CHARACTERS,
    LOCATIONS,
    PROFILE
}

data class ButtomNavItem(
    val destination: BottomNavDestination,
    val title: String,
    val icon: ImageVector
)

@Composable
fun ButtomNavBar(
    currentRoute: String,
    onItemSelected: (BottomNavDestination) -> Unit
) {
    val items = listOf(
        ButtomNavItem(BottomNavDestination.CHARACTERS, "Characters", Icons.Default.People),
        ButtomNavItem(BottomNavDestination.LOCATIONS, "Locations", Icons.Default.LocationOn),
        ButtomNavItem(BottomNavDestination.PROFILE, "Profile", Icons.Default.Person)
    )

    NavigationBar {
        items.forEach { item ->
            val isSelected = when (item.destination) {
                BottomNavDestination.CHARACTERS -> currentRoute.contains("characters")
                BottomNavDestination.LOCATIONS -> currentRoute.contains("locations")
                BottomNavDestination.PROFILE -> currentRoute == "profile"
            }

            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                selected = isSelected,
                onClick = { onItemSelected(item.destination) }
            )
        }
    }
}