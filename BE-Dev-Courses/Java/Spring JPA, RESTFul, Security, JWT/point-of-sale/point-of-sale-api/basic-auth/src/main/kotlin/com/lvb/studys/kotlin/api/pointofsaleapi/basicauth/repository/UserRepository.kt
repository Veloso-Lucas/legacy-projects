package com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.repository

import com.lvb.studys.kotlin.api.pointofsaleapi.basicauth.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.sales WHERE u.username = :username")
    fun findUserByUsername(@Param("username") username: String): User
}