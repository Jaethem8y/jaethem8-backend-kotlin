package com.jaethem8.jaethem8.controller.admin

import com.jaethem8.jaethem8.dto.blog.BlogPostDTO
import com.jaethem8.jaethem8.model.blog.BlogPost
import com.jaethem8.jaethem8.service.blog.BlogService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class BlogController(
        private val blogService: BlogService
) {
    @CrossOrigin
    @PostMapping("/add/blogPost")
    fun addBlogPost(@RequestBody blogPostDTO: BlogPostDTO): BlogPost {
        return blogService.addBlogPost(blogPostDTO)
    }

    @CrossOrigin
    @PostMapping("/edit/blogPost")
    fun editBlogPost(@RequestBody blogPostDTO: BlogPostDTO): BlogPost {
        return blogService.editBlogPost(blogPostDTO)
    }

    @CrossOrigin
    @PostMapping("/delete/blogPost")
    fun deleteBlogPost(@RequestBody blogPostDTO: BlogPostDTO) {
        blogService.deleteBlogPost(blogPostDTO)
    }
}
