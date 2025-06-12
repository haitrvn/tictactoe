package com.haitrvn.domain.usecase

class UserLoginValidationUseCase {
    suspend fun validatePassword(password: String): List<PasswordValidationError> {
        TODO()
    }

    suspend fun validateUserName(username: String): List<UsernameValidationError> {
        TODO()
    }
}


sealed interface UsernameValidationError {
    object Empty : UsernameValidationError
    object TooShort : UsernameValidationError
    object InvalidCharacter : UsernameValidationError
}

sealed interface PasswordValidationError {
    object Empty : PasswordValidationError
    object TooShort : PasswordValidationError
    object NoDigit : PasswordValidationError
    object NoUppercase : PasswordValidationError
}
