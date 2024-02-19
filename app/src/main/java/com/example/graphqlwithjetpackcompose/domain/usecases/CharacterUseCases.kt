package com.example.graphqlwithjetpackcompose.domain.usecases

data class CharacterUseCases(
    val getCharacterByIdUseCase: GetCharacterByIdUseCase,
    val getCharacterListUseCase: GetCharacterListUseCase
)
