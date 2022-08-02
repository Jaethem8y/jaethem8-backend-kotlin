package com.jaethem8.jaethem8.dto.blog

import com.jaethem8.jaethem8.dto.ContentDTO

data class BlogPostDTO(
        var title: String,
        var role: String,
        var frontend: String,
        var backend: String,
        var general: String,
        var description: String,
        var blogContents: List<ContentDTO> = mutableListOf()
)