package com.lvb.studys.kotlin.api.wsuserlogin.repository

import com.lvb.studys.kotlin.api.wsuserlogin.entity.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface IUserRepository : MongoRepository<User, String> {

    fun findByEmail(email: String): Optional<User>
}