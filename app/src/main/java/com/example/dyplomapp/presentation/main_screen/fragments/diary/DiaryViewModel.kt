package com.example.dyplomapp.presentation.main_screen.fragments.diary

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.dyplomapp.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DiaryViewModel @Inject constructor(): ViewModel() {
    private val _state = mutableStateOf(DiaryState())
    val state: State<DiaryState> = _state

    fun onEvent(event: DiaryEvent){
        when(event){
            is DiaryEvent.changeDay ->{
                _state.value = state.value.copy(
                    indexDay = event.index
                )
            }
        }
    }
}