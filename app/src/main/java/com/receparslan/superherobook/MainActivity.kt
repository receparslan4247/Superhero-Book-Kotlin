package com.receparslan.superherobook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.receparslan.superherobook.model.Superhero
import com.receparslan.superherobook.ui.screens.DetailScreen
import com.receparslan.superherobook.ui.screens.HomeScreen
import com.receparslan.superherobook.ui.screens.ListScreen
import java.net.URLDecoder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // NavController manages app navigation within a NavHost.
            val navController = rememberNavController()

            // A NavHost is a container for navigation, and it is the top-level composable for a navigation graph.
            NavHost(navController = navController, startDestination = "home_screen") {
                // composable is a destination that displays a composable function.
                composable("home_screen") {
                    HomeScreen(navController)
                }
                composable(
                    "list_screen/{superheroList}",
                    arguments = listOf(
                        navArgument("superheroList") { type = NavType.StringType }
                    )
                ) {
                    // URLDecoder is used to decode the URL-encoded string.
                    val decodedJSonString = it.arguments?.getString("superheroList")

                    // Gson is used to convert the JSON string to a list of Superhero objects.
                    val superheroList: List<Superhero> =
                        Gson().fromJson(URLDecoder.decode(decodedJSonString, "utf-8"), object : TypeToken<List<Superhero>>() {}.type)

                    // ListScreen is a composable function that displays a list of superheroes.
                    ListScreen(superheroList, navController)
                }
                composable(
                    "detail_screen/{superhero}",
                    arguments = listOf(
                        navArgument("superhero") { type = NavType.StringType }
                    )
                ) {
                    // URLDecoder is used to decode the URL-encoded string.
                    val decodedJSonString = it.arguments?.getString("superhero")

                    // Gson is used to convert the JSON string to a Superhero object.
                    val superhero: Superhero = Gson().fromJson(URLDecoder.decode(decodedJSonString, "utf-8"), Superhero::class.java)

                    // DetailScreen is a composable function that displays the details of a superhero.
                    DetailScreen(superhero, navController)
                }
            }
        }
    }
}