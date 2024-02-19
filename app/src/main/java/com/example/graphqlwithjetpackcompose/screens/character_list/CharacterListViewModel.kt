package com.example.graphqlwithjetpackcompose.screens.character_list

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
class CharacterListViewModel @Inject constructor(private val useCases: CharacterUseCases):ViewModel(){

    private val _state = MutableStateFlow(CharacterListState())
    val state = _state.asStateFlow()


    init {
        _state.update {it

            it.copy(
                isLoading = true,
            )

        }

        viewModelScope.launch {
            val result = useCases.getCharacterListUseCase.execute()

            _state.update {characterListState ->

                characterListState.copy(
                    isLoading = false,
                    characterList = result
                )

            }
        }
    }

}