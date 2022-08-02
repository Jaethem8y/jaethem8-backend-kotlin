package com.jaethem8.jaethem8.repository.blog

import com.jaethem8.jaethem8.model.blog.BlogContent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BlogContentRepository : JpaRepository<BlogContent, Long> {
    fun findContentByPostName(postName: String): List<BlogContent>
}