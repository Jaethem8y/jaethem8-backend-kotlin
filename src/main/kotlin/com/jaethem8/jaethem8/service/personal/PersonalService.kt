package com.jaethem8.jaethem8.service.personal

import com.jaethem8.jaethem8.dto.personal.PersonalContentDTO
import com.jaethem8.jaethem8.dto.personal.PersonalPostDTO
import com.jaethem8.jaethem8.model.personal.PersonalContent
import com.jaethem8.jaethem8.model.personal.PersonalPost
import com.jaethem8.jaethem8.repository.personal.PersonalContentRepository
import com.jaethem8.jaethem8.repository.personal.PersonalPostRepository
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class PersonalService(
    private val personalPostRepository: PersonalPostRepository,
    private val personalContentRepository: PersonalContentRepository
) {
    fun getAllPersonalPost(): List<PersonalPost> {
        return personalPostRepository.findAll()
    }

    fun getPersonalContentByPostName(postName: String): List<PersonalContent> {
        return personalContentRepository.findContentByPostName(postName)
    }

    fun getPersonalPostByTitle(title: String): PersonalPost {
        return personalPostRepository.findByTitle(title)

    }

    fun getPersonalContentById(id: Long): PersonalContent {
        return personalContentRepository.findById(id).get()
    }

    fun addPersonalPost(personalPostDTO: PersonalPostDTO): PersonalPost {
        var personalPost = PersonalPost()
        personalPost.pubDate = Date()
        personalPost.title = personalPostDTO.title
        return personalPostRepository.save(personalPost)
    }

    fun addPersonalContent(personalContentDTO: PersonalContentDTO): PersonalPost {
        var personalContent = PersonalContent()
        var personalPost = personalPostRepository.findByTitle(personalContentDTO.title)
        personalContent.postName = personalContentDTO.title
        personalContent.content = personalContentDTO.content
        personalContent.location = personalContentDTO.location
        personalContent.code = personalContentDTO.code
        personalContent.personalPost = personalPost
        personalPost!!.personalContents += personalContent
        return personalPostRepository.save(personalPost)
    }
}