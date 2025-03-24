package com.thisisnotajoke.interview

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thisisnotajoke.interview.model.People
import com.thisisnotajoke.interview.model.PeopleState
import com.thisisnotajoke.interview.repository.MobileInterviewRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleListViewModel @Inject constructor(
    private val service: MobileInterviewRepository
) : ViewModel() {

    init {
        refresh()
    }

    private val _people = MutableStateFlow<PeopleState>(PeopleState.Loading)
    val people: StateFlow<PeopleState> = _people

    fun refresh(onComplete: () -> Unit = {}) {
        viewModelScope.launch {
            fetchPeople()
            onComplete()
        }
    }

    private suspend fun fetchPeople() {
        try {
            val result = service.getPeople()
            Log.d("PeopleListViewModel", "fetchPeople: $result")
            if (result.isSuccessful) {
                _people.value = PeopleState.Success(result.body() ?: People())
            } else {
                _people.value = PeopleState.Error(error = result.errorBody().toString())
            }
        } catch (e: IllegalArgumentException) {
            _people.value = PeopleState.Error(error = e.message ?: "Unknown error")
            Log.e("PeopleListViewModel", "fetchPeople: $e")
        }
    }
}

