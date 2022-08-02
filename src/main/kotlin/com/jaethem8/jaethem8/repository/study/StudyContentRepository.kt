package com.jaethem8.jaethem8.repository.study

import com.jaethem8.jaethem8.model.study.StudyContent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudyContentRepository : JpaRepository<StudyContent, Long> {
    fun findContentByPostName(postName: String): List<StudyContent>

}