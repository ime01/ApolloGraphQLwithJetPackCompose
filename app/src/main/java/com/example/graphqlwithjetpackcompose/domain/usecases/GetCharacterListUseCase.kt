package com.example.graphqlwithjetpackcompose.domain.usecases

import com.example.graphqlwithjetpackcompose.domain.model.SimpleCharacter
import com.example.graphqlwithjetpackcompose.domain.network.RickAndMortyClient


class GetCharacterListUseCase (private val client: RickAndMortyClient) {

    suspend fun execute():List<SimpleCharacter>{
       return client.getCharacterlist()
    }


}