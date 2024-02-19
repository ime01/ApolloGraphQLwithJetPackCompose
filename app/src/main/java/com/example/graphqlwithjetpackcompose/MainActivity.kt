package com.example.graphqlwithjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.graphqlwithjetpackcompose.screens.character_details.CharacterScreen
import com.example.graphqlwithjetpackcompose.screens.character_list.CharacterListScreen
import com.example.graphqlwithjetpackcompose.ui.theme.GraphQLwithJetPackComposeTheme
import com.example.graphqlwithjetpackcompose.utils.Routes
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraphQLwithJetPackComposeTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Routes.characterList){

                    composable(Routes.characterList) {

                        CharacterListScreen(onCharacterClicked = {id->
                            navController.navigate(Routes.character.replace("{id}", id))

                        })
                    }

                    composable(Routes.character){

                        CharacterScreen (navigateBack ={ navController.popBackStack()})

                    }

                }

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GraphQLwithJetPackComposeTheme {

    }
}