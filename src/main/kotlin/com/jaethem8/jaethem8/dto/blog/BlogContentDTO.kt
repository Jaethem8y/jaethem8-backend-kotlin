package com.jaethem8.jaethem8.dto.blog

data class BlogContentDTO(
    var title: String = "",
    var location: Int = 0,
    var content: String? = null,
    var image: String? = null,
    var code: String? = null,
)