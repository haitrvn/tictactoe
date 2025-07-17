@file:OptIn(ExperimentalCoroutinesApi::class)

package com.haitrvn.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haitrvn.core.flatMapFirst
import com.haitrvn.domain.model.UserLogin
import com.haitrvn.domain.usecase.UserLoginUseCase
import com.haitrvn.domain.usecase.UserLoginValidationUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val userLoginUseCase: UserLoginUseCase,
    private val userLoginValidationUseCase: UserLoginValidationUseCase
) : ViewModel() {
    private val _uiState: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState.Empty)
    val uiState = _uiState.asStateFlow()

    private val actionSharedFlow = MutableSharedFlow<LoginAction>()
    private inline fun <reified T : LoginAction> action() = actionSharedFlow.filterIsInstance<T>()

    internal fun dispatch(action: LoginAction) {
        viewModelScope.launch {
            actionSharedFlow.emit(action)
        }
    }

    init {
        action<LoginAction.UsernameChanged>()
            .map { it.username }
            .flatMapLatest { username ->
                flow {
                    emit(userLoginValidationUseCase.validateUserName(username) to username)
                }
            }.onEach { (isValid, username) ->
                _uiState.value = _uiState.value.copy(username = username)
            }.launchIn(viewModelScope)

        action<LoginAction.PasswordChanged>()
            .map { it.password }
            .flatMapLatest { password ->
                flow {
                    emit(userLoginValidationUseCase.validateUserName(password) to password)
                }
            }.onEach { (isValid, password) ->
                _uiState.value = _uiState.value.copy(password = password)
            }.launchIn(viewModelScope)

        action<LoginAction.LoginClicked>().onEach {
            println("Login clicked")
        }.flatMapFirst {
            flow {
                _uiState.update { it.copy(isLoading = true) }
                userLoginUseCase.invoke(UserLogin(_uiState.value.username, _uiState.value.password))
                    .onSuccess {
                        emit(true)
                    }.onFailure {
                        emit(false)
                    }
            }
        }.onEach {
            println("Login clicked after flatmap")
            val loginSuccessful =
                (_uiState.value.username == "admin" && _uiState.value.password == "password")
            _uiState.update {
                it.copy(
                    isLoading = false,
                    errorMessage = if (loginSuccessful) "" else "Invalid credentials"
                )
            }
        }.launchIn(viewModelScope)
    }
}

data class LoginUiState(
    val username: String,
    val password: String,
    val isHidePassword: Boolean,
    val usernameErrorMessage: String,
    val passwordErrorMessage: String,
    val errorMessage: String,
    val isLoading: Boolean,
) {
    companion object {
        val Empty = LoginUiState(
            username = "",
            password = "",
            isHidePassword = true,
            usernameErrorMessage = "",
            passwordErrorMessage = "",
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