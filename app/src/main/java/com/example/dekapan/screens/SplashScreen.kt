package com.example.dekapan.screens

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dekapan.R
import com.example.dekapan.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(3000) // Splash tampil selama 3 detik
        navController.navigate(Screen.Home.route) {
            popUpTo(Screen.Splash.route) { inclusive = true } // Hapus splash dari back stack
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Splash Logo",
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .aspectRatio(1f)
        )
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "SELAMAT DATANG DI APLIKASI DETEKSI KACANG PANJANG",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
        )


    }
}
