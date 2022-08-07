package com.jaethem8.jaethem8.service.blog

import com.jaethem8.jaethem8.dto.ContentDTO
import com.jaethem8.jaethem8.dto.ImageDTO
import com.jaethem8.jaethem8.dto.LinkDTO
import com.jaethem8.jaethem8.dto.blog.BlogPostDTO
import com.jaethem8.jaethem8.model.blog.BlogContent
import com.jaethem8.jaethem8.model.blog.BlogImage
import com.jaethem8.jaethem8.model.blog.BlogLink
import com.jaethem8.jaethem8.model.blog.BlogPost
import com.jaethem8.jaethem8.repository.blog.BlogContentRepository
import com.jaethem8.jaethem8.repository.blog.BlogPostRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class BlogServiceImpl(
        private val blogPostRepository: BlogPostRepository,
        private val blogContentRepository: BlogContentRepository
) : BlogService {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @Transactional
    override fun getAllBlogPost(): List<BlogPost> {
        return blogPostRepository.findAll()
    }

    @Transactional
    override fun getBlogPostById(id: Long): BlogPost {
        return blogPostRepository.findByIdOrNull(id) ?: throw Exception("No Post with Given ID")
    }

    @Transactional
    override fun getBlogPostByTitle(title: String): BlogPost {
        return blogPostRepository.findBlogPostByTitle(title) ?: throw Exception("No Post with Given Name")
    }

    @Transactional
    override fun addBlogPost(blogPostDTO: BlogPostDTO): BlogPost {
        var blogPost = BlogPost()
        blogPost.title = blogPostDTO.title
        blogPost.role = blogPostDTO.role
        blogPost.frontend = blogPostDTO.frontend
        blogPost.backend = blogPostDTO.backend
        blogPost.general = blogPostDTO.general
        blogPost.description = blogPostDTO.description
        for (blogContentDTO in blogPostDTO.blogContents) {
            var blogContent: BlogContent = addBlogContent(blogContentDTO)
            blogPost.blogContents += blogContent
            blogContent.blogPost = blogPost
        }
        return blogPostRepository.save(blogPost)
    }

    override fun addBlogContent(blogContentDTO: ContentDTO): BlogContent {
        var blogContent = BlogContent()
        blogContent.location = blogContentDTO.location
        blogContent.header = blogContentDTO.header
        blogContent.content = blogContentDTO.content
        for (blogLinkDTO in blogContentDTO.links) {
            var blogLink = addBlogLink(blogLinkDTO)
            blogContent.blogLinks += blogLink
            blogLink.blogContent = blogContent
        }
        for (blogImageDTO in blogContentDTO.images) {
            var blogImage = addBlogImage(blogImageDTO)
            blogContent.blogImages += blogImage
            blogImage.blogContent = blogContent
        }
        return blogContent
    }

    override fun addBlogImage(blogImageDTO: ImageDTO): BlogImage {
        var blogImage = BlogImage()
        blogImage.image = blogImageDTO.image
        return blogImage
    }

    override fun addBlogLink(blogLinkDTO: LinkDTO): BlogLink {
        var blogLink = BlogLink()
        blogLink.tag = blogLinkDTO.tag
        blogLink.link = blogLinkDTO.link
        return blogLink
    }

    @Transactional
    override fun editBlogPost(blogPostDTO: BlogPostDTO): BlogPost {
        var blogPost = blogPostRepository.findBlogPostByTitle(blogPostDTO.title)
                ?: throw Exception("Post Does Not Exist")
        blogContentRepository.deleteByBlogPost(blogPost)
        blogPost.blogContents = mutableListOf()
        for (blogContentDTO in blogPostDTO.blogContents) {
            var blogContent: BlogContent = addBlogContent(blogContentDTO)
            blogPost.blogContents += blogContent
            blogContent.blogPost = blogPost
        }
        return blogPostRepository.save(blogPost)
    }

    override fun deleteBlogPost(blogPostDTO: BlogPostDTO) {
        var blogPost = blogPostRepository.findBlogPostByTitle(blogPostDTO.title)
                ?: throw Exception("Post Does Not Exist")
        return blogPostRepository.delete(blogPost)
    }

}










