package com.jaethem8.jaethem8.repository.study

import com.jaethem8.jaethem8.model.study.StudyPost
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudyPostRepository : JpaRepository<StudyPost, Long> {
    fun findByTitle(title: String): StudyPost
    fun deleteByTitle(title: String)
}