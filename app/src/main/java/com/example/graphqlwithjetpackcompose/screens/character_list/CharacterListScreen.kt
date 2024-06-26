package com.example.graphqlwithjetpackcompose.screens.character_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun CharacterListScreen(
    viewModel: CharacterListViewModel = hiltViewModel(),
    onCharacterClicked: (String) -> Unit
) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current


    Scaffold { padding ->

        LazyColumn(
            contentPadding = PaddingValues(
                top = padding.calculateTopPadding() + 15.dp,
                bottom = padding.calculateBottomPadding() + 15.dp,
                start = 20.dp,
                end = 20.dp
            )
        ) {
            items(state.characterList) { character ->

                ListItem(
                    headlineContent = {
                        Text(text = character.name)
                    },

                    supportingContent = {
                        Text(text = character.species)
                    },
                    leadingContent = {
                        AsyncImage(
                            model = ImageRequest
                                .Builder(context)
                                .data(character.image)
                                .crossfade(true)
                                .build(),
                            contentDescription = "${character.name} Image",
                            modifier = Modifier.size(64.dp)
                        )
                    },

                    modifier = Modifier.clickable {
                        onCharacterClicked(character.id)
                    }
                )

            }
        }

    }

}