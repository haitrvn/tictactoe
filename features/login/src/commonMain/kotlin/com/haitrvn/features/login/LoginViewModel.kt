package com.haitrvn.features.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class LoginViewModel() : ViewModel() { // Giả sử UserRepository đã được inject
    private val _uiState: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState.Empty)
    val uiState = _uiState.asStateFlow()

    private val actionSharedFlow = MutableSharedFlow<LoginAction>()
    private inline fun <reified T : LoginAction> action() =
        actionSharedFlow.filterIsInstance<T>()

    internal fun dispatch(action: LoginAction) {
        viewModelScope.launch {
            actionSharedFlow.emit(action)
        }
    }

    init {
        action<LoginAction.UsernameChanged>()
            .map { it.username }
            .flatMapLatest { username ->
                flowOf(true to username)
            }
            .onEach { (isValid, username) ->
                _uiState.value =
                    _uiState.value.copy(username = username)
            }.launchIn(viewModelScope)

        action<LoginAction.PasswordChanged>()
            .map { it.password }
            .flatMapLatest { password ->
                flowOf(true to password)
            }
            .onEach { (isValid, password) ->
                _uiState.value =
                    _uiState.value.copy(password = password)
            }.launchIn(viewModelScope)
    }
}

data class LoginUiState(
    val username: String,
    val password: String,
    val isHidePassword: Boolean,
    val errorMessage: String,
    val isLoading: Boolean,
) {
    companion object {
        val Empty = LoginUiState(
            username = "",
            password = "",
            isHidePassword = true,
            errorMessage = "",
            isLoading = false,
        )
    }
}

interface Action

sealed interface LoginAction : Action {
    data class UsernameChanged(val username: String) : LoginAction
    data class PasswordChanged(val password: String) : LoginAction
    object LoginClicked : LoginAction
}

// Giả sử UserRepository
interface UserRepository {
    fun isValidUsername(username: String): Boolean
}