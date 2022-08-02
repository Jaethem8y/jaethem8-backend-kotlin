package com.jaethem8.jaethem8.model.study

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.jaethem8.jaethem8.model.Post
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "blog_post")
data class StudyPost(
        override var id: Long?,
        override var title: String?,
        override var description: String,
        override var pubDate: Timestamp?,
        @JsonManagedReference
        @OneToMany(mappedBy = "studyPost", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        var studyContents: List<StudyContent> = mutableListOf()
) : Post(id, title, description, pubDate)
