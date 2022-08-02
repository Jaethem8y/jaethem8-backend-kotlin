package com.jaethem8.jaethem8.model.personal

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.jaethem8.jaethem8.model.Post
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "blog_post")
data class PersonalPost(
        override var id: Long?,
        override var title: String?,
        override var description: String,
        override var pubDate: Timestamp?,
        @JsonManagedReference
        @OneToMany(mappedBy = "personalPost", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        var personalContents: List<PersonalContent> = mutableListOf()
) : Post(id, title, description, pubDate)
