package com.limaa.lab8moviles.ui.charactersscreen


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String
)

private val characters: List<Character> = listOf(
    Character(1, "Rick Sanchez", "Alive", "Human", "Male"),
    Character(2, "Morty Smith", "Alive", "Human", "Male"),
    Character(3, "Summer Smith", "Alive", "Human", "Female"),
    Character(4, "Beth Smith", "Alive", "Human", "Female"),
    Character(5, "Jerry Smith", "Alive", "Human", "Male"),
    Character(6, "Abadango Cluster Princess", "Alive", "Alien", "Female"),
    Character(7, "Abradolf Lincler", "unknown", "Human", "Male"),
    Character(8, "Adjudicator Rick", "Dead", "Human", "Male"),
    Character(9, "Agency Director", "Dead", "Human", "Male"),
    Character(10, "Alan Rails", "Dead", "Human", "Male"),
    Character(11, "Albert Einstein", "Dead", "Human", "Male"),
    Character(12, "Alexander", "Dead", "Human", "Male"),
    Character(13, "Alien Googah", "unknown", "Alien", "unknown"),
    Character(14, "Alien Morty", "unknown", "Alien", "Male"),
    Character(15, "Alien Rick", "unknown", "Alien", "Male"),
    Character(16, "Amish Cyborg", "Dead", "Alien", "Male"),
    Character(17, "Annie", "Alive", "Human", "Female"),
    Character(18, "Antenna Morty", "Alive", "Human", "Male"),
    Character(19, "Antenna Rick", "unknown", "Human", "Male"),
    Character(20, "Ants in my Eyes Johnson", "unknown", "Human", "Male")
)

@Composable
fun CharactersScreen(
    onNavigateToCharacterDetail: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Characters",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(characters.size) { index ->
                val character = characters[index]
                CharacterRow(
                    character = character,
                    onClick = { onNavigateToCharacterDetail(character.id) }
                )
            }
        }
    }
}

@Composable
private fun CharacterRow(
    character: Character,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Character Avatar",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
        }

        Column {
            Text(
                text = character.name,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "${character.status} • ${character.species} • ${character.gender}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
