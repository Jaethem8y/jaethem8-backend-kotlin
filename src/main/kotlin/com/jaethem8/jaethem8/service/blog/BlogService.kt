package com.jaethem8.jaethem8.service.blog

import com.jaethem8.jaethem8.dto.blog.BlogContentDTO
import com.jaethem8.jaethem8.dto.blog.BlogPostDTO
import com.jaethem8.jaethem8.model.blog.BlogContent
import com.jaethem8.jaethem8.model.blog.BlogPost
import com.jaethem8.jaethem8.repository.blog.BlogContentRepository
import com.jaethem8.jaethem8.repository.blog.BlogPostRepository
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class BlogService(
    private val blogContentRepository: BlogContentRepository,
    private val blogPostRepository: BlogPostRepository
) {
    fun getAllBlogPost(): List<BlogPost> {
        return blogPostRepository.findAll()
    }

    fun getBlogContentByPostName(postName: String): List<BlogContent> {
        return blogContentRepository.findContentByPostName(postName)
    }

    fun getBlogPostByTitle(title: String): BlogPost {
        return blogPostRepository.findByTitle(title)
    }

    fun getBlogContentById(id: Long): BlogContent {
        return blogContentRepository.findById(id).get()
    }

    fun addBlogPost(blogPostDTO: BlogPostDTO): BlogPost {
        var blogPost = BlogPost()
        blogPost.pubDate = Date()
        blogPost.title = blogPostDTO.title
        blogPost.role = blogPostDTO.role
        blogPost.frontend = blogPostDTO.frontend
        blogPost.backend = blogPostDTO.backend
        blogPost.general = blogPostDTO.general
        return blogPostRepository.save(blogPost)
    }

    fun addBlogContent(blogContentDTO: BlogContentDTO): BlogPost {
        var blogContent = BlogContent()
        var blogPost = blogPostRepository.findByTitle(blogContentDTO.title)
        blogContent.postName = blogContentDTO.title
        blogContent.content = blogContentDTO.content
        blogContent.location = blogContentDTO.location
        blogContent.code = blogContentDTO.code
        blogContent.image = blogContentDTO.image
        blogContent.blogPost = blogPost
        blogPost!!.blogContents += blogContent
        return blogPostRepository.save(blogPost)
    }
}