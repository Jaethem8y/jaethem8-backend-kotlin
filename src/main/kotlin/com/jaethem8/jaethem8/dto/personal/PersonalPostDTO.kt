package com.jaethem8.jaethem8.dto.personal

import com.jaethem8.jaethem8.model.Content

data class PersonalPostDTO(
        var title: String,
        var description:String,
        var personalContents:List<Content> = mutableListOf()
)