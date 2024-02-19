package com.example.graphqlwithjetpackcompose.screens.character_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graphqlwithjetpackcompose.domain.usecases.CharacterUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val useCases: CharacterUseCases,
    private val savedStateHandle: SavedStateHandle):ViewModel(){

    private val _state = MutableStateFlow(CharacterState())
    val state = _state.asStateFlow()


    init {
        _state.update {it
            it.copy(
                isLoading = true,
            )
        }

        savedStateHandle.get<String>("id")?.let { id->
            viewModelScope.launch {

                val result = useCases.getCharacterByIdUseCase.execute(id)

                _state.update {characterState ->

                    characterState.copy(
                        isLoading = false,
                        character = result
                    )

                }
            }
        }

    }

}