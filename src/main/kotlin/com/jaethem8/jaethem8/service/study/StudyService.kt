package com.jaethem8.jaethem8.service.study

import com.jaethem8.jaethem8.dto.ContentDTO
import com.jaethem8.jaethem8.dto.ImageDTO
import com.jaethem8.jaethem8.dto.LinkDTO
import com.jaethem8.jaethem8.dto.study.StudyPostDTO
import com.jaethem8.jaethem8.model.study.StudyContent
import com.jaethem8.jaethem8.model.study.StudyImage
import com.jaethem8.jaethem8.model.study.StudyLink
import com.jaethem8.jaethem8.model.study.StudyPost

interface StudyService {
    interface StudyService {
        fun getAllStudyPost(): List<StudyPost>
        fun getStudyPostById(id: Long): StudyPost
        fun getStudyPostByTitle(title: String): StudyPost
        fun addStudyPost(studyPostDTO: StudyPostDTO): StudyPost
        fun addStudyContent(studyContentDTO: ContentDTO): StudyContent
        fun addStudyImage(studyImageDTO: ImageDTO): StudyImage
        fun addStudyLink(studyLinkDTO: LinkDTO): StudyLink
        fun editStudyPost(studyPostDTO: StudyPostDTO): StudyPost
        fun deleteStudyPost(studyPostId: Int)
    }
}