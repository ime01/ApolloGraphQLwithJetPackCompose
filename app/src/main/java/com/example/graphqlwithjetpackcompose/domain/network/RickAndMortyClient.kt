package com.example.graphqlwithjetpackcompose.domain.network

import com.example.graphqlwithjetpackcompose.domain.model.Character
import com.example.graphqlwithjetpackcompose.domain.model.SimpleCharacter

interface RickAndMortyClient {

    suspend fun getCharacterlist(): List<SimpleCharacter>

    suspend fun getCharacterById(id:String): Character?
}