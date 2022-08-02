package com.jaethem8.jaethem8.repository.blog

import com.jaethem8.jaethem8.model.blog.BlogPost
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BlogPostRepository : JpaRepository<BlogPost, Long> {
    fun findByTitle(title: String): BlogPost
    fun deleteByTitle(title: String)
}