package com.example.dekapan.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.dekapan.models.DiseaseInfo

data class Plant(val name: String, val description: String)

@Composable
fun PlantListScreen() {
    val plants = listOf(
        "Bean Rust", "Angular Leaf Spot", "Yellow Mosaic", "Powdery Mildew", "Leaf Crinkle"
    )

    // State untuk menyimpan kondisi apakah card sedang diperluas atau tidak
    val expandedStates = remember { mutableStateMapOf<String, Boolean>() }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(plants) { plant ->
            val isExpanded = expandedStates[plant] ?: false // Default false jika belum diklik

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { expandedStates[plant] = !isExpanded }, // Toggle expand saat diklik
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF4CAF50),  contentColor = Color.White) // Warna hijau
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = plant,
                        style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center // Judul di tengah
                    )

                    if (isExpanded) {
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = DiseaseInfo.getDiseaseDetail(plant),
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Justify // Rata kiri-kanan
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Solusi:",
                            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Start
                        )

                        Text(
                            text = DiseaseInfo.getSolutionDetail(plant),
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Justify // Rata kiri-kanan
                        )
                    }
                }
            }
        }
    }
}
