package com.limaa.lab9moviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.limaa.lab9moviles.ui.characterscreen.CharacterDetailScreen
import com.limaa.lab9moviles.ui.charactersscreen.CharactersScreen
import com.limaa.lab9moviles.ui.Locationscreen.Location
import com.limaa.lab9moviles.ui.Locationsscreen.Locations
import com.limaa.lab9moviles.ui.loginscreen.LoginScreen
import com.limaa.lab9moviles.ui.Profilescreen.Profile
import com.limaa.lab9moviles.ui.Components.ButtomNavBar
import com.limaa.lab9moviles.ui.Components.BottomNavDestination
import com.limaa.lab9moviles.navigation.CharacterDetail
import com.limaa.lab9moviles.navigation.Characters
import com.limaa.lab9moviles.navigation.CharactersGraph
import com.limaa.lab9moviles.navigation.LocationDetail
import com.limaa.lab9moviles.navigation.Locations
import com.limaa.lab9moviles.navigation.LocationsGraph
import com.limaa.lab9moviles.navigation.Login
import com.limaa.lab9moviles.navigation.Profile as ProfileRoute
import com.limaa.lab9moviles.ui.theme.Lab9MovilesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab9MovilesTheme {
                val navController = rememberNavController()
                var showBottomBar by remember { mutableStateOf(false) }
                var currentRoute by remember { mutableStateOf("login") }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        if (showBottomBar) {
                            ButtomNavBar(
                                currentRoute = currentRoute,
                                onItemSelected = { destination ->
                                    when (destination) {
                                        BottomNavDestination.CHARACTERS -> {
                                            currentRoute = "characters_graph"
                                            navController.navigate(CharactersGraph) {
                                                popUpTo(CharactersGraph) {
                                                    inclusive = false
                                                    saveState = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                        BottomNavDestination.LOCATIONS -> {
                                            currentRoute = "locations_graph"
                                            navController.navigate(LocationsGraph) {
                                                popUpTo(CharactersGraph) {
                                                    inclusive = false
                                                    saveState = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                        BottomNavDestination.PROFILE -> {
                                            currentRoute = "profile"
                                            navController.navigate(ProfileRoute) {
                                                popUpTo(CharactersGraph) {
                                                    inclusive = false
                                                    saveState = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    }
                                }
                            )
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Login,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable<Login> {
                            showBottomBar = false
                            currentRoute = "login"
                            LoginScreen(
                                onNavigateToCharacters = {
                                    showBottomBar = true
                                    currentRoute = "characters_graph"
                                    navController.navigate(CharactersGraph)
                                }
                            )
                        }

                        navigation<CharactersGraph>(
                            startDestination = Characters
                        ) {
                            composable<Characters> {
                                showBottomBar = true
                                currentRoute = "characters_graph"
                                CharactersScreen(
                                    onNavigateToCharacterDetail = { characterId ->
                                        showBottomBar = false
                                        navController.navigate(CharacterDetail(characterId))
                                    }
                                )
                            }

                            composable<CharacterDetail> { backStackEntry ->
                                showBottomBar = false
                                val characterDetail = backStackEntry.toRoute<CharacterDetail>()
                                CharacterDetailScreen(
                                    characterId = characterDetail.characterId,
                                    onNavigateBack = {
                                        showBottomBar = true
                                        currentRoute = "characters_graph"
                                        navController.popBackStack()
                                    }
                                )
                            }
                        }

                        navigation<LocationsGraph>(
                            startDestination = Locations
                        ) {
                            composable<Locations> {
                                showBottomBar = true
                                currentRoute = "locations_graph"
                                Locations(
                                    onNavigateToLocationDetail = { locationId ->
                                        showBottomBar = false
                                        navController.navigate(LocationDetail(locationId))
                                    }
                                )
                            }

                            composable<LocationDetail> { backStackEntry ->
                                showBottomBar = false
                                val locationDetail = backStackEntry.toRoute<LocationDetail>()
                                Location(
                                    locationId = locationDetail.locationId,
                                    onNavigateBack = {
                                        showBottomBar = true
                                        currentRoute = "locations_graph"
                                        navController.popBackStack()
                                    }
                                )
                            }
                        }

                        composable<ProfileRoute> {
                            showBottomBar = true
                            currentRoute = "profile"
                            Profile(
                                onLogout = {
                                    showBottomBar = false
                                    currentRoute = "login"
                                    navController.navigate(Login) {
                                        popUpTo(Login) { inclusive = true }
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}