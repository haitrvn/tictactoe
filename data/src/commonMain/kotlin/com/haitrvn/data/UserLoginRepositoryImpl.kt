package com.haitrvn.data

import com.haitrvn.domain.UserLoginRepository
import com.haitrvn.domain.model.User
import com.haitrvn.domain.model.UserLogin

class UserLoginRepositoryImpl : UserLoginRepository {
    override fun login(login: UserLogin): Result<User> {
        TODO("Not yet implemented")
    }
}