package com.jaethem8.jaethem8.controller.admin

import com.jaethem8.jaethem8.dto.study.StudyContentDTO
import com.jaethem8.jaethem8.dto.study.StudyPostDTO
import com.jaethem8.jaethem8.model.study.StudyContent
import com.jaethem8.jaethem8.model.study.StudyPost
import com.jaethem8.jaethem8.service.study.StudyService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class StudyController(
    private val studyService: StudyService
) {

    @GetMapping("/studyPost")
    fun getStudyPosts(model: Model): String {
        val studyPosts: List<StudyPost> = studyService.getAllStudyPost()
        model.addAttribute("studyPosts", studyPosts)
        return "study/studyPosts"
    }

    @GetMapping("/studyPost/{postName}")
    fun getStudyPost(@PathVariable postName: String, model: Model): String {
        val studyPost: StudyPost = studyService.getStudyPostByTitle(postName)
        model.addAttribute("studyPost", studyPost)
        return "study/studyPost"
    }

    @GetMapping("/studyContents/{postName}")
    fun getStudyContentsByPostName(@PathVariable postName: String): String {
        val studyContents: List<StudyContent> = studyService.getStudyContentByPostName(postName)
        return "/study/studyContents"
    }

    @GetMapping("/studyContent/{id}")
    fun getStudyContentById(@PathVariable id: Long, model: Model): String {
        val studyContent: StudyContent = studyService.getStudyContentById(id)
        model.addAttribute("studyContent", studyContent)
        return "/study/studyContent"
    }

    @GetMapping("add/studyPost")
    fun addStudyPost(@ModelAttribute("studyPostDTO") studyPostDTO: StudyPostDTO): String {
        return "study/addStudyPost"
    }

    @GetMapping("add/studyContent")
    fun addStudyContent(@ModelAttribute("studyContentDTO") studyContentDTO: StudyContentDTO): String {
        return "study/addStudyContent"
    }

    @PostMapping("add/studyPost")
    fun addProcessStudyPost(@ModelAttribute("studyPostDTO") studyPostDTO: StudyPostDTO): String {
        studyService.addStudyPost(studyPostDTO)
        return "study/addStudyPost"
    }

    @PostMapping("add/studyContent")
    fun addProcessStudyContent(@ModelAttribute("studyContentDTO") studyContentDTO: StudyContentDTO): String {
        studyService.addStudyContent(studyContentDTO)
        return "study/addStudyContent"
    }
}