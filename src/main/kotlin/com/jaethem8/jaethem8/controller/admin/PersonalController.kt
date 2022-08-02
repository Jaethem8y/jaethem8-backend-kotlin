package com.jaethem8.jaethem8.controller.admin

import com.jaethem8.jaethem8.dto.personal.PersonalContentDTO
import com.jaethem8.jaethem8.dto.personal.PersonalPostDTO
import com.jaethem8.jaethem8.model.personal.PersonalContent
import com.jaethem8.jaethem8.model.personal.PersonalPost
import com.jaethem8.jaethem8.service.personal.PersonalService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class PersonalController(
    private val personalService: PersonalService
) {
    @GetMapping("/personalPost")
    fun getPersonalPosts(model: Model): String {
        val personalPosts: List<PersonalPost> = personalService.getAllPersonalPost()
        model.addAttribute("personalPosts", personalPosts)
        return "personal/personalPosts"
    }

    @GetMapping("/personalPost/{postName}")
    fun getPersonalPost(@PathVariable postName: String, model: Model): String {
        val personalPost: PersonalPost = personalService.getPersonalPostByTitle(postName)
        model.addAttribute("personalPost", personalPost)
        return "personal/personalPost"
    }

    @GetMapping("/personalContents/{postName}")
    fun getPersonalContentsByPostName(@PathVariable postName: String): String {
        val personalContents: List<PersonalContent> = personalService.getPersonalContentByPostName(postName)
        return "/personal/personalContents"
    }

    @GetMapping("/personalContent/{id}")
    fun getPersonalContentById(@PathVariable id: Long, model: Model): String {
        val personalContent: PersonalContent = personalService.getPersonalContentById(id)
        model.addAttribute("personalContent", personalContent)
        return "/personal/personalContent"
    }

    @GetMapping("add/personalPost")
    fun addPersonalPost(@ModelAttribute("personalPostDTO") personalPostDTO: PersonalPostDTO): String {
        return "personal/addPersonalPost"
    }

    @GetMapping("add/personalContent")
    fun addPersonalContent(@ModelAttribute("personalContentDTO") personalContentDTO: PersonalContentDTO): String {
        return "personal/addPersonalContent"
    }

    @PostMapping("add/personalPost")
    fun addProcessPersonalPost(@ModelAttribute("personalPostDTO") personalPostDTO: PersonalPostDTO): String {
        personalService.addPersonalPost(personalPostDTO)
        return "personal/addPersonalPost"
    }

    @PostMapping("add/personalContent")
    fun addProcessPersonalContent(@ModelAttribute("personalContentDTO") personalContentDTO: PersonalContentDTO): String {
        personalService.addPersonalContent(personalContentDTO)
        return "personal/addPersonalContent"
    }
}