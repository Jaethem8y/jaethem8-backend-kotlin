package com.jaethem8.jaethem8.model.blog

import com.fasterxml.jackson.annotation.JsonBackReference
import com.jaethem8.jaethem8.model.Link
import javax.persistence.*

@Entity
@Table(name = "blog_link")
data class BlogLink(
        override var id: Long?,
        override var tag: String?,
        override var link: String?,
        override var location: Int?,
        @ManyToOne(cascade = [CascadeType.PERSIST])
        @JsonBackReference
        @JoinColumn(name = "blog_content_id")
        var blogContent: BlogContent? = null
) : Link(id, link, tag, location)
