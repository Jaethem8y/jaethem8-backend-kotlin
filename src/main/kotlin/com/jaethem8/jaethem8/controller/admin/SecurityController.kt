package com.jaethem8.jaethem8.controller.admin

import com.jaethem8.jaethem8.dto.blog.BlogContentDTO
import com.jaethem8.jaethem8.dto.blog.BlogPostDTO
import com.jaethem8.jaethem8.model.user.User
import com.jaethem8.jaethem8.service.blog.BlogService
import com.jaethem8.jaethem8.service.personal.PersonalService
import com.jaethem8.jaethem8.service.study.StudyService
import com.jaethem8.jaethem8.service.user.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class SecurityController(
    private val blogService: BlogService,
    private val personalService: PersonalService,
    private val studyService: StudyService,
    private val userService: UserService
) {
    @GetMapping("/login")
    fun login(): String {
        return "login"
    }

    @GetMapping("/")
    fun home(): String {
        return "home"
    }

    @GetMapping("/registration")
    fun getRegistration(@ModelAttribute("user") user: User): String {
        return "registration"
    }

    @PostMapping("/registration")
    fun registerAdmin(@ModelAttribute("user") user: User): String {
        userService.save(user)
        return "redirect:/registration?success"
    }


    @GetMapping("/blog/addPost")
    fun getAddBlogPost(model: Model): String {
        model.addAttribute("blogPostDTO", BlogPostDTO())
        return "blog/blogPostAdd";
    }

    @PostMapping("/blog/addPost")
    fun addBlogPost(@ModelAttribute blogPostDTO: BlogPostDTO): String {
        blogService.addBlogPost(blogPostDTO)
        return "/blog/blogPostAdd"
    }

    @GetMapping("/blog/addContent")
    fun getAddBlogContent(model: Model): String {
        model.addAttribute("blogContentDTO", BlogContentDTO())
        return "blog/blogContentAdd";
    }

    @PostMapping("/blog/addContent")
    fun addBlogContent(@ModelAttribute blogContentDTO: BlogContentDTO): String {
        blogService.addBlogContent(blogContentDTO)
        return "/blog/blogContentAdd"
    }
}