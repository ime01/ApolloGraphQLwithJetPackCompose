package com.example.graphqlwithjetpackcompose.screens.character_details

import com.example.graphqlwithjetpackcompose.domain.model.Character

data class CharacterState(
    val isLoading:Boolean = false,
    val character: Character? = null
)
