package com.haitrvn.domain

import com.haitrvn.domain.model.User
import com.haitrvn.domain.model.UserLogin

interface UserLoginRepository {
    fun login(login: UserLogin): Result<User>
}