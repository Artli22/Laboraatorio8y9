package com.limaa.lab8moviles.ui.characterscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

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
fun CharacterDetailScreen(
    characterId: Int,
    onNavigateBack: () -> Unit
) {
    val character = characters.find { it.id == characterId }

    if (character == null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Character not found",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.error
            )
        }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onNavigateBack) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver"
                )
            }

            Text(
                text = "Character Detail",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Character Avatar",
                tint = Color.White,
                modifier = Modifier.size(80.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = character.name,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CharacterInfoRow(
                label = "Species:",
                value = character.species
            )

            CharacterInfoRow(
                label = "Status:",
                value = character.status
            )

            CharacterInfoRow(
                label = "Gender:",
                value = character.gender
            )
        }
    }
}

@Composable
private fun CharacterInfoRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.weight(2f)
        )
    }
}