package com.jaethem8.jaethem8.dto

data class ContentDTO(
        var location: Int,
        var header: String,
        var content: String,
        var images: List<ImageDTO> = mutableListOf(),
        var links: List<LinkDTO> = mutableListOf()
)
