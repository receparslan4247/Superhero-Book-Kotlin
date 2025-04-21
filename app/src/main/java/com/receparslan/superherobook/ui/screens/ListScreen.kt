package com.receparslan.superherobook.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
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
import com.google.gson.Gson
import com.receparslan.superherobook.R
import com.receparslan.superherobook.model.Superhero
import com.receparslan.superherobook.ui.theme.dcBlue
import com.receparslan.superherobook.ui.theme.marvelRed
import java.net.URLEncoder

// These variables are used to set the app bar text, icon, and border color.
private var appBarText: String? = null
private var appBarIcon: Int? = null
private var borderColor: Color? = null

// ListScreen is a composable function that displays a list of superheroes.
@Composable
fun ListScreen(superheroList: List<Superhero>, navController: NavController) {

    // If the first superhero in the list is from Marvel Comics, set the app bar text to "Marvel" and the app bar icon to the Marvel logo.
    if (superheroList[0].publisher == "Marvel Comics") {
        appBarText = "Marvel"
        appBarIcon = R.drawable.marvel
        borderColor = marvelRed
    } else {
        appBarText = "DC"
        appBarIcon = R.drawable.dc
        borderColor = dcBlue
    }

    Scaffold(
        topBar = { TopAppBar(appBarText!!, appBarIcon!!, navController) },
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            items(superheroList) {
                SuperheroRow(superhero = it, navController)
            }
        }
    }
}

// SuperheroRow is a composable function that displays a row containing a superhero's image and name.
@Composable
private fun SuperheroRow(superhero: Superhero, navController: NavController) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                // URLEncoder is used to encode the superhero object as a JSON string.
                val encodedString = URLEncoder.encode(Gson().toJson(superhero), "utf-8")

                // Navigate to the detail screen with the encoded superhero object as an argument.
                navController.navigate("detail_screen/$encodedString")
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            bitmap = ImageBitmap.imageResource(superhero.image),
            contentDescription = superhero.name,
            modifier = Modifier
                .size(125.dp)
                .clip(CircleShape)
                .border(BorderStroke(5.dp, borderColor!!), CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(
            text = superhero.name,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 50.sp,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                shadow = Shadow(Color.LightGray, offset = Offset(5.0f, 10.0f), blurRadius = 3f)
            ),
            color = Color.White
        )
    }
}

// TopAppBar is a composable function that displays the app bar with the specified text and icon.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(text: String, id: Int, navController: NavController) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Yellow,
            titleContentColor = Color.Black
        ),
        title = {
            Text(
                text = text,
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.W500,
                textAlign = TextAlign.Center,
                style = TextStyle(shadow = Shadow(Color.LightGray, offset = Offset(5.0f, 10.0f), blurRadius = 3f)),
            )
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Localized description"
                )
            }
        }, actions = {
            Box(
                modifier = Modifier
                    .size(100.dp, 60.dp)
                    .padding(4.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Image(
                    painter = painterResource(id),
                    contentDescription = text,
                    contentScale = ContentScale.Inside
                )
            }
        }
    )
}

// Preview the ListScreen composable.
@Preview
@Composable
private fun ListScreenPreview() {
    ListScreen(Superhero.Companion.getMarvelSuperheroes(), rememberNavController())
}