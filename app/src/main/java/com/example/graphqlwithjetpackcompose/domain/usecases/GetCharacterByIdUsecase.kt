package com.example.graphqlwithjetpackcompose.domain.usecases

import com.example.graphqlwithjetpackcompose.domain.model.Character
import com.example.graphqlwithjetpackcompose.domain.network.RickAndMortyClient

class GetCharacterByIdUseCase(private val client: RickAndMortyClient) {

    suspend fun execute(id:String): Character? {
        return client.getCharacterById(id)
    }

}