package com.example.graphqlwithjetpackcompose.di

import com.apollographql.apollo3.ApolloClient
import com.example.graphqlwithjetpackcompose.data.network.ApolloRickAndMortyClient
import com.example.graphqlwithjetpackcompose.domain.network.RickAndMortyClient
import com.example.graphqlwithjetpackcompose.domain.usecases.CharacterUseCases
import com.example.graphqlwithjetpackcompose.domain.usecases.GetCharacterByIdUseCase
import com.example.graphqlwithjetpackcompose.domain.usecases.GetCharacterListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun providesApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://rickandmortyapi.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun providesRickAndMortyClient(apolloClient: ApolloClient): RickAndMortyClient {
        return ApolloRickAndMortyClient(apolloClient)
    }

    @Provides
    @Singleton
    fun providesCharacterUseCases(rickAndMortyClient: RickAndMortyClient): CharacterUseCases {
        return CharacterUseCases(
            getCharacterByIdUseCase = GetCharacterByIdUseCase(client = rickAndMortyClient),
            getCharacterListUseCase = GetCharacterListUseCase(client = rickAndMortyClient)
        )
    }

}