package com.jaethem8.jaethem8.repository.user

import com.jaethem8.jaethem8.model.user.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String?): User
}