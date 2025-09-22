package com.limaa.lab9moviles.ui.Profilescreen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun Profile(
    onLogout: () -> Unit = {},
    imageUrl: String = "https://www.pngall.com/wp-content/uploads/4/Brad-Pitt-PNG-File.png"
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen simple con Coil
        AsyncImage(
            model = imageUrl,
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Nombre: Arturo Lima",
            fontSize = 15.sp,
            color = Color.Black
        )
        Text(
            text = "Carné: 24683",
            fontSize = 15.sp,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedButton(
            onClick = onLogout,
            shape = CircleShape
        ) {
            Text("Cerrar sesión")
        }
    }
}