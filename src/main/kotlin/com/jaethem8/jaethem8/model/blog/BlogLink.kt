package com.jaethem8.jaethem8.model.blog

import com.fasterxml.jackson.annotation.JsonBackReference
import com.jaethem8.jaethem8.model.Link
import javax.persistence.*

@Entity
@Table(name = "blog_link")
data class BlogLink(
        override var id: Long? = 0,
        override var tag: String? = null,
        override var link: String? = null,
        override var location: Int? = null,
        @ManyToOne(cascade = [CascadeType.PERSIST])
        @JsonBackReference
        @JoinColumn(name = "blog_content_id")
        var blogContent: BlogContent? = null
) : Link(id, link, tag, location)
