package com.example.graphqlwithjetpackcompose.data.mapper

import com.apcoding.CharacterQuery
import com.apcoding.CharactersQuery
import com.example.graphqlwithjetpackcompose.domain.model.Character
import com.example.graphqlwithjetpackcompose.domain.model.SimpleCharacter


fun CharactersQuery.Characters.toCharacterList(): List<SimpleCharacter> {

    return this.results?.mapNotNull { result ->

        SimpleCharacter(
            id = result?.id.orEmpty(),
            name = result?.name.orEmpty(),
            image = result?.image.orEmpty(),
            species = result?.species.orEmpty()
        )

    }.orEmpty()
}

fun CharacterQuery.Character.toCharacter(): Character {

    return Character(
        id = this.id.orEmpty(),
        name = this.name.orEmpty(),
        gender = this.gender.orEmpty(),
        image = this.image.orEmpty()
    )
}