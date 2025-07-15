package com.haitrvn.domain.usecase

class UserLoginValidationUseCase {
    
    companion object {
        private const val MIN_USERNAME_LENGTH = 3
        private const val MAX_USERNAME_LENGTH = 20
        private const val MIN_PASSWORD_LENGTH = 8
        private val USERNAME_REGEX = Regex("^[a-zA-Z0-9_.]+$")
        private val DIGIT_REGEX = Regex(".*\\d.*")
        private val UPPERCASE_REGEX = Regex(".*[A-Z].*")
        private val SPECIAL_CHAR_REGEX = Regex(".*[!@#\$%^&*()_+\\-=\\[\\]{}|;:,.<>?].*")
    }
    
    suspend fun validatePassword(password: String): List<PasswordValidationError> {
        val errors = mutableListOf<PasswordValidationError>()
        
        when {
            password.isEmpty() -> errors.add(PasswordValidationError.Empty)
            password.length < MIN_PASSWORD_LENGTH -> errors.add(PasswordValidationError.TooShort)
        }
        
        if (password.isNotEmpty()) {
            if (!DIGIT_REGEX.matches(password)) {
                errors.add(PasswordValidationError.NoDigit)
            }
            if (!UPPERCASE_REGEX.matches(password)) {
                errors.add(PasswordValidationError.NoUppercase)
            }
            if (!SPECIAL_CHAR_REGEX.matches(password)) {
                errors.add(PasswordValidationError.NoSpecialCharacter)
            }
        }
        
        return errors
    }

    suspend fun validateUserName(username: String): List<UsernameValidationError> {
        val errors = mutableListOf<UsernameValidationError>()
        
        when {
            username.isEmpty() -> errors.add(UsernameValidationError.Empty)
            username.length < MIN_USERNAME_LENGTH -> errors.add(UsernameValidationError.TooShort)
            username.length > MAX_USERNAME_LENGTH -> errors.add(UsernameValidationError.TooLong)
        }
        
        if (username.isNotEmpty()) {
            if (!USERNAME_REGEX.matches(username)) {
                errors.add(UsernameValidationError.InvalidCharacter)
            }
            if (username.startsWith('.') || username.endsWith('.')) {
                errors.add(UsernameValidationError.InvalidDotPosition)
            }
            if (username.contains("..")) {
                errors.add(UsernameValidationError.ConsecutiveDots)
            }
        }
        
        return errors
    }
}

sealed interface UsernameValidationError {
    object Empty : UsernameValidationError
    object TooShort : UsernameValidationError
    object TooLong : UsernameValidationError
    object InvalidCharacter : UsernameValidationError
    object InvalidDotPosition : UsernameValidationError
    object ConsecutiveDots : UsernameValidationError
}

sealed interface PasswordValidationError {
    object Empty : PasswordValidationError
    object TooShort : PasswordValidationError
    object NoDigit : PasswordValidationError
    object NoUppercase : PasswordValidationError
    object NoSpecialCharacter : PasswordValidationError
}
