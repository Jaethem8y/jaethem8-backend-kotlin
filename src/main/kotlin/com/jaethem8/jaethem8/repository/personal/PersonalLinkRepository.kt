package com.jaethem8.jaethem8.repository.personal

import com.jaethem8.jaethem8.model.personal.PersonalLink
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonalLinkRepository : JpaRepository<PersonalLink, Long> {
}