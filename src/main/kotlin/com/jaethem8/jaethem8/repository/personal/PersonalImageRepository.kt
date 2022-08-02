package com.jaethem8.jaethem8.repository.personal

import com.jaethem8.jaethem8.model.personal.PersonalImage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonalImageRepository : JpaRepository<PersonalImage, Long> {
}