package com.jaethem8.jaethem8.model.study

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.jaethem8.jaethem8.model.Post
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "blog_post")
data class StudyPost(
        override var id: Long? = 0,
        override var title: String? = null,
        override var description: String? = null,
        override var pubDate: Timestamp? = null,
        @JsonManagedReference
        @OneToMany(mappedBy = "studyPost", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        var studyContents: List<StudyContent> = mutableListOf()
) : Post(id, title, description, pubDate)
