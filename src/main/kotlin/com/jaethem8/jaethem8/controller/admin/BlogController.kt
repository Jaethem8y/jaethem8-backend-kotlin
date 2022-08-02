package com.jaethem8.jaethem8.controller.admin

import com.jaethem8.jaethem8.dto.blog.BlogContentDTO
import com.jaethem8.jaethem8.dto.blog.BlogPostDTO
import com.jaethem8.jaethem8.model.blog.BlogContent
import com.jaethem8.jaethem8.model.blog.BlogPost
import com.jaethem8.jaethem8.service.blog.BlogService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class BlogController(
    private val blogService: BlogService
) {
    @GetMapping("/blogPost")
    fun getBlogPosts(model: Model): String {
        val blogPosts: List<BlogPost> = blogService.getAllBlogPost()
        model.addAttribute("blogPosts", blogPosts)
        return "blog/blogPosts"
    }

    @GetMapping("/blogPost/{postName}")
    fun getBlogPost(@PathVariable postName: String, model: Model): String {
        val blogPost: BlogPost = blogService.getBlogPostByTitle(postName)
        model.addAttribute("blogPost", blogPost)
        return "blog/blogPost"
    }

    @GetMapping("/blogContents/{postName}")
    fun getBlogContentsByPostName(@PathVariable postName: String): String {
        val blogContents: List<BlogContent> = blogService.getBlogContentByPostName(postName)
        return "/blog/blogContents"
    }

    @GetMapping("/blogContent/{id}")
    fun getBlogContentById(@PathVariable id: Long, model: Model): String {
        val blogContent: BlogContent = blogService.getBlogContentById(id)
        model.addAttribute("blogContent", blogContent)
        return "/blog/blogContent"
    }

    @GetMapping("add/blogPost")
    fun addBlogPost(@ModelAttribute("blogPostDTO") blogPostDTO: BlogPostDTO): String {
        return "blog/addBlogPost"
    }

    @GetMapping("add/blogContent")
    fun addBlogContent(@ModelAttribute("blogContentDTO") blogContentDTO: BlogContentDTO): String {
        return "blog/addBlogContent"
    }

    @PostMapping("add/blogPost")
    fun addProcessBlogPost(@ModelAttribute("blogPostDTO") blogPostDTO: BlogPostDTO): String {
        blogService.addBlogPost(blogPostDTO)
        return "blog/addBlogPost"
    }

    @PostMapping("add/blogContent")
    fun addProcessBlogContent(@ModelAttribute("blogContentDTO") blogContentDTO: BlogContentDTO): String {
        blogService.addBlogContent(blogContentDTO)
        return "blog/addBlogContent"
    }
}