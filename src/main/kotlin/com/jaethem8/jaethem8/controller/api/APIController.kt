package com.jaethem8.jaethem8.controller.api

import com.jaethem8.jaethem8.model.blog.BlogPost
import com.jaethem8.jaethem8.model.personal.PersonalPost
import com.jaethem8.jaethem8.model.study.StudyPost
import com.jaethem8.jaethem8.service.blog.BlogService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/API")
class APIController(
    private val blogService: BlogService
) {
    @CrossOrigin
    @GetMapping("/blogPost")
    fun getBlogPosts(): List<BlogPost?>? {
        return blogService.getAllBlogPost()
    }

    @CrossOrigin
    @GetMapping("/blogPost/{title}")
    fun getBlogPostByTitle(@PathVariable title: String?): BlogPost {
        return blogService!!.getBlogPostByTitle(title!!)
    }
}
