package com.example.dekapan.navigation

import com.example.dekapan.R

sealed class Screen(val route: String, val label: String, val icon: Int) {
    object Home : Screen("home", "Beranda", R.drawable.logo)
    object Camera : Screen("camera", "Prediksi", R.drawable.logo)
    object PlantList : Screen("plants", "Penyakit", R.drawable.logo)
    object Splash : Screen("splash", "Splash", R.drawable.logo)
}
