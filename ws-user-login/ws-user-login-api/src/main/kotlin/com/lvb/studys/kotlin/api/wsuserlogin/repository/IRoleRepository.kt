package com.lvb.studys.kotlin.api.wsuserlogin.repository

import com.lvb.studys.kotlin.api.wsuserlogin.entity.Role
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface IRoleRepository : MongoRepository<Role, String> {

    fun findByName(name: String): Optional<Role>
}