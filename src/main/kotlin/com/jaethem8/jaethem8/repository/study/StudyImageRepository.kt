package com.jaethem8.jaethem8.repository.study

import com.jaethem8.jaethem8.model.study.StudyImage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudyImageRepository : JpaRepository<StudyImage, Long> {
}