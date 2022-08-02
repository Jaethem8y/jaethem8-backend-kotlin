package com.jaethem8.jaethem8.service.personal

import com.jaethem8.jaethem8.dto.ContentDTO
import com.jaethem8.jaethem8.dto.ImageDTO
import com.jaethem8.jaethem8.dto.LinkDTO
import com.jaethem8.jaethem8.dto.personal.PersonalPostDTO
import com.jaethem8.jaethem8.model.personal.PersonalContent
import com.jaethem8.jaethem8.model.personal.PersonalImage
import com.jaethem8.jaethem8.model.personal.PersonalLink
import com.jaethem8.jaethem8.model.personal.PersonalPost

interface PersonalService {
    interface PersonalService {
        fun getAllPersonalPost(): List<PersonalPost>
        fun getPersonalPostById(id: Long): PersonalPost
        fun getPersonalPostByTitle(title: String): PersonalPost
        fun addPersonalPost(personalPostDTO: PersonalPostDTO): PersonalPost
        fun addPersonalContent(personalContentDTO: ContentDTO): PersonalContent
        fun addPersonalImage(personalImageDTO: ImageDTO): PersonalImage
        fun addPersonalLink(personalLinkDTO: LinkDTO): PersonalLink
        fun editPersonalPost(personalPostDTO: PersonalPostDTO): PersonalPost
        fun deletePersonalPost(personalPostId: Int)
    }
}