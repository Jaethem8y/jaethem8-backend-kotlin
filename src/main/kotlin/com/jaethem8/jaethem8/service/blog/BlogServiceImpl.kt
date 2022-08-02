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
import com.jaethem8.jaethem8.repository.blog.BlogImageRepository
import com.jaethem8.jaethem8.repository.blog.BlogLinkRepository
import com.jaethem8.jaethem8.repository.blog.BlogPostRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class BlogServiceImpl(
        private val blogImageRepository: BlogImageRepository,
        private val blogLinkRepository: BlogLinkRepository,
        private val blogContentRepository: BlogContentRepository,
        private val blogPostRepository: BlogPostRepository
) : BlogService {
    override fun getAllBlogPost(): List<BlogPost> {
        return blogPostRepository.findAll() ?: throw Exception("No Blog Post Exist at the Moment")
    }

    override fun getBlogPostById(id: Long): BlogPost {
        return blogPostRepository.findByIdOrNull(id) ?: throw Exception("No Post with Given ID")
    }

    override fun getBlogPostByTitle(title: String): BlogPost {
        return blogPostRepository.findBlogPostByTitle(title) ?: throw Exception("No Post with Given Name")
    }

    override fun addBlogPost(blogPostDTO: BlogPostDTO): BlogPost {
        TODO("Not yet implemented")
    }

    override fun addBlogContent(blogContentDTO: ContentDTO): BlogContent {
        TODO("Not yet implemented")
    }

    override fun addBlogImage(blogImageDTO: ImageDTO): BlogImage {
        TODO("Not yet implemented")
    }

    override fun addBlogLink(blogLinkDTO: LinkDTO): BlogLink {
        TODO("Not yet implemented")
    }

    override fun editBlogPost(blogPostDTO: BlogPostDTO): BlogPost {
        TODO("Not yet implemented")
    }

    override fun deleteBlogPost(blogPostId: Int) {
        TODO("Not yet implemented")
    }

}










