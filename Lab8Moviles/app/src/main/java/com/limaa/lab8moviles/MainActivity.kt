package com.limaa.lab8moviles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.limaa.lab8moviles.ui.characterscreen.CharacterDetailScreen
import com.limaa.lab8moviles.ui.charactersscreen.CharactersScreen
import com.limaa.lab8moviles.ui.loginscreen.LoginScreen
import com.limaa.lab8moviles.navigation.CharacterDetail
import com.limaa.lab8moviles.navigation.Characters
import com.limaa.lab8moviles.navigation.Login
import com.limaa.lab8moviles.ui.theme.Lab8MovilesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab8MovilesTheme {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Login,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable<Login> {
                            LoginScreen(
                                onNavigateToCharacters = {
                                    navController.navigate(Characters)
                                }
                            )
                        }

                        composable<Characters> {
                            CharactersScreen(
                                onNavigateToCharacterDetail = { characterId ->
                                    navController.navigate(CharacterDetail(characterId))
                                }
                            )
                        }

                        composable<CharacterDetail> { backStackEntry ->
                            val characterDetail = backStackEntry.toRoute<CharacterDetail>()
                            CharacterDetailScreen(
                                characterId = characterDetail.characterId,
                                onNavigateBack = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}