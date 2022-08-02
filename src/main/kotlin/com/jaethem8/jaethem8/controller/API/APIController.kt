package com.jaethem8.jaethem8.controller.API

import com.jaethem8.jaethem8.model.blog.BlogPost
import com.jaethem8.jaethem8.service.blog.BlogService

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/API")
@RestController
class APIController(
    private val blogService: BlogService,
) {
    @CrossOrigin
    @GetMapping("/blogPost")
    fun getAllBlogPost(): List<BlogPost> {
        return blogService.getAllBlogPost();
    }

    @CrossOrigin
    @GetMapping("/blogPost/{title}")
    fun getBlogPostById(@PathVariable title: String): BlogPost? {
        return blogService.getBlogPostByTitle(title)
    }
}