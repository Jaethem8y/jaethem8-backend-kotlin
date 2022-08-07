package com.jaethem8.jaethem8.service.blog

import com.jaethem8.jaethem8.dto.ContentDTO
import com.jaethem8.jaethem8.dto.ImageDTO
import com.jaethem8.jaethem8.dto.LinkDTO
import com.jaethem8.jaethem8.dto.blog.BlogPostDTO
import com.jaethem8.jaethem8.model.blog.BlogContent
import com.jaethem8.jaethem8.model.blog.BlogImage
import com.jaethem8.jaethem8.model.blog.BlogLink
import com.jaethem8.jaethem8.model.blog.BlogPost

interface BlogService {
    fun getAllBlogPost(): List<BlogPost>
    fun getBlogPostById(id: Long): BlogPost
    fun getBlogPostByTitle(title: String): BlogPost
    fun addBlogPost(blogPostDTO: BlogPostDTO): BlogPost
    fun addBlogContent(blogContentDTO: ContentDTO): BlogContent
    fun addBlogImage(blogImageDTO: ImageDTO): BlogImage
    fun addBlogLink(blogLinkDTO: LinkDTO): BlogLink
    fun editBlogPost(blogPostDTO: BlogPostDTO): BlogPost
    fun deleteBlogPost(blogPostDTO: BlogPostDTO)
}