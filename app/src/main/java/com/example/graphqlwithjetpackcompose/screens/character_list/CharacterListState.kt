package com.example.graphqlwithjetpackcompose.screens.character_list

import com.example.graphqlwithjetpackcompose.domain.model.SimpleCharacter

data class CharacterListState(
    val isLoading:Boolean = false,
    val characterList: List<SimpleCharacter> = emptyList()
)
