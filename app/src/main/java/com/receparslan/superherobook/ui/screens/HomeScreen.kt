package com.receparslan.superherobook.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.gson.Gson
import com.receparslan.superherobook.R
import com.receparslan.superherobook.model.Superhero
import java.net.URLEncoder

// HomeScreen composable function displays the home screen.
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = { AppBar() }, modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.Black),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.marvel),
                contentDescription = "Marvel Logo",
                modifier = Modifier
                    .size(350.dp)
                    .padding(8.dp)
                    .clickable {
                        // URLEncoder is used to encode the JSON string.
                        val encodedString = URLEncoder.encode(Gson().toJson(Superhero.Companion.getMarvelSuperheroes()), "utf-8")

                        // Navigate to the ListScreen with the encoded JSON string.
                        navController.navigate("list_screen/$encodedString")
                    }
            )
            Image(
                painter = painterResource(R.drawable.dc),
                contentDescription = "DC Logo",
                modifier = Modifier
                    .size(300.dp)
                    .padding(8.dp)
                    .clickable {
                        // URLEncoder is used to encode the JSON string.
                        val encodedString = URLEncoder.encode(Gson().toJson(Superhero.Companion.getDCSuperheroes()), "utf-8")

                        // Navigate to the ListScreen with the encoded JSON string.
                        navController.navigate("list_screen/$encodedString")
                    }
            )
        }

    }
}

// AppBar composable function displays the app bar.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar() {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Yellow,
            titleContentColor = Color.Black,
        ),
        title = {
            Text(
                text = "Superhero Book",
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.W500,
                style = TextStyle(shadow = Shadow(Color.LightGray, offset = Offset(5.0f, 10.0f), blurRadius = 3f))
            )
        }
    )
}

// Preview the HomeScreen.
@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    HomeScreen(rememberNavController())
}