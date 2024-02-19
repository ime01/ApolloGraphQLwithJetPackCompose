package com.example.graphqlwithjetpackcompose.data.network

import com.apcoding.CharacterQuery
import com.apcoding.CharactersQuery
import com.apollographql.apollo3.ApolloClient
import com.example.graphqlwithjetpackcompose.data.mapper.toCharacter
import com.example.graphqlwithjetpackcompose.data.mapper.toCharacterList
import com.example.graphqlwithjetpackcompose.domain.model.Character
import com.example.graphqlwithjetpackcompose.domain.model.SimpleCharacter
import com.example.graphqlwithjetpackcompose.domain.network.RickAndMortyClient

class ApolloRickAndMortyClient(private val apolloClient: ApolloClient): RickAndMortyClient {
    
    override suspend fun getCharacterlist(): List<SimpleCharacter> {
       return  apolloClient
             .query(CharactersQuery())
             .execute()
             .data
             ?.characters
             ?.toCharacterList()
             .orEmpty()
    }

    override suspend fun getCharacterById(id: String): Character? {
      return apolloClient
            .query(CharacterQuery(id))
            .execute()
            .data
            ?.character
            ?.toCharacter()
    }
}