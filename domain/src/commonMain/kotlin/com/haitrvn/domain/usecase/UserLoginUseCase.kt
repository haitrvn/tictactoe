package com.haitrvn.domain.usecase

import com.haitrvn.domain.UserLoginRepository
import com.haitrvn.domain.model.User
import com.haitrvn.domain.model.UserLogin

class UserLoginUseCase(
    private val userLoginRepository: UserLoginRepository
) {
    suspend operator fun invoke(userLogin: UserLogin): Result<User> {
        return userLoginRepository.login(userLogin)
    }
}