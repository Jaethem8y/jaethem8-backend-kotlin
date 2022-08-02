package com.jaethem8.jaethem8.dto.study

import com.jaethem8.jaethem8.model.Content

data class StudyPostDTO(
        var title: String,
        var description: String,
        var studyContents:List<Content> = mutableListOf()
)