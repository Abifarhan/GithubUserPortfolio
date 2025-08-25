package com.abitask.githubuserportfolio.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abitask.githubuserportfolio.domain.model.User
import com.abitask.githubuserportfolio.domain.usecase.IGetUserDetailUseCase
import com.abitask.githubuserportfolio.presentation.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val getUserDetail: IGetUserDetailUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<User>>(UiState.Loading)
    val uiState: StateFlow<UiState<User>> = _uiState

    fun load(login: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val detail = getUserDetail(login)
                _uiState.value = UiState.Success(detail)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Unknown Error", e)
            }
        }
    }
}