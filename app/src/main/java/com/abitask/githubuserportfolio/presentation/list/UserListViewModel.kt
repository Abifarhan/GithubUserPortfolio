package com.abitask.githubuserportfolio.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abitask.githubuserportfolio.domain.model.User
import com.abitask.githubuserportfolio.domain.usecase.ILoadInitialUsersUseCase
import com.abitask.githubuserportfolio.domain.usecase.ISearchUsersUseCase
import com.abitask.githubuserportfolio.presentation.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val loadInitialUsers: ILoadInitialUsersUseCase,
    private val searchUsers: ISearchUsersUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<User>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<User>>> = _uiState

    init {
        getInitialData()
    }

    private fun getInitialData() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val data = loadInitialUsers()
                _uiState.value = UiState.Success(data)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Unknown Error", e)
            }
        }
    }

    fun setQuery(q: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val result = if (q.isBlank()) {
                    loadInitialUsers()
                } else {
                    searchUsers(q)
                }
                _uiState.value = UiState.Success(result)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Unknown Error", e)
            }
        }
    }
}