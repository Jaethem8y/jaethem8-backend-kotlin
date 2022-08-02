package com.jaethem8.jaethem8.repository.personal

import com.jaethem8.jaethem8.model.personal.PersonalPost
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonalPostRepository : JpaRepository<PersonalPost, Long> {
    fun findByTitle(title: String): PersonalPost
    fun deleteByTitle(title: String)
}