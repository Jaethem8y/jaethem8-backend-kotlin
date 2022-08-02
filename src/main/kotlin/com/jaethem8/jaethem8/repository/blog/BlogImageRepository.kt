package com.jaethem8.jaethem8.repository.blog

import com.jaethem8.jaethem8.model.blog.BlogImage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BlogImageRepository : JpaRepository<BlogImage, Long> {
}