package com.receparslan.superherobook.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.receparslan.superherobook.R
import com.receparslan.superherobook.model.Superhero
import com.receparslan.superherobook.ui.theme.dcBlue
import com.receparslan.superherobook.ui.theme.marvelRed

// The superhero object is declared as a global variable.
private lateinit var superhero: Superhero

// DetailScreen is a composable function that displays the details of a superhero.
@Composable
fun DetailScreen(superheroParam: Superhero, navController: NavController) {
    superhero = superheroParam // The superhero object is assigned the value of the superheroParam parameter.

    Scaffold(
        topBar = { TopAppBar(superhero.name, if (superhero.publisher == "DC Comics") R.drawable.dc else R.drawable.marvel, navController) },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.Black),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(superhero.image),
                contentDescription = superhero.name,
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                contentScale = ContentScale.FillHeight,
            )
            Text(
                text = superhero.realName,
                fontSize = 48.sp,
                textAlign = TextAlign.Center,
                color = if (superhero.publisher == "DC Comics") dcBlue else marvelRed,
                style = TextStyle(
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.W500,
                    shadow = Shadow(Color.LightGray, offset = Offset(5.0f, 10.0f), blurRadius = 3f)
                )
            )
            Text(
                text = superhero.bio,
                fontSize = 28.sp,
                color = Color.White,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(8.dp),
                style = TextStyle(
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.W500,
                    shadow = Shadow(Color.LightGray, offset = Offset(5.0f, 10.0f), blurRadius = 15f)
                )
            )
        }
    }
}

// PreviewDetailScreen is a composable function that displays a preview of the DetailScreen composable function.
@Preview(showBackground = true)
@Composable
private fun PreviewDetailScreen() {
    DetailScreen(Superhero.Companion.getSuperheroes()[1], rememberNavController())
}