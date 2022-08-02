package com.jaethem8.jaethem8.service.study

import com.jaethem8.jaethem8.dto.study.StudyContentDTO
import com.jaethem8.jaethem8.dto.study.StudyPostDTO
import com.jaethem8.jaethem8.model.study.StudyContent
import com.jaethem8.jaethem8.model.study.StudyPost
import com.jaethem8.jaethem8.repository.study.StudyContentRepository
import com.jaethem8.jaethem8.repository.study.StudyPostRepository
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class StudyService(
    private val studyPostRepository: StudyPostRepository,
    private val studyContentRepository: StudyContentRepository
) {
    fun getAllStudyPost(): List<StudyPost> {
        return studyPostRepository.findAll()
    }

    fun getStudyContentByPostName(postName: String): List<StudyContent> {
        return studyContentRepository.findContentByPostName(postName)
    }

    fun getStudyPostByTitle(title: String): StudyPost {
        return studyPostRepository.findByTitle(title)

    }

    fun getStudyContentById(id: Long): StudyContent {
        return studyContentRepository.findById(id).get()
    }

    fun addStudyPost(studyPostDTO: StudyPostDTO): StudyPost {
        var studyPost = StudyPost()
        studyPost.pubDate = Date()
        studyPost.title = studyPostDTO.title
        return studyPostRepository.save(studyPost)
    }

    fun addStudyContent(studyContentDTO: StudyContentDTO): StudyPost {
        var studyContent = StudyContent()
        var studyPost = studyPostRepository.findByTitle(studyContentDTO.title)
        studyContent.postName = studyContentDTO.title
        studyContent.content = studyContentDTO.content
        studyContent.location = studyContentDTO.location
        studyContent.code = studyContentDTO.code
        studyContent.studyPost = studyPost
        studyPost!!.studyContents += studyContent
        return studyPostRepository.save(studyPost)
    }
}