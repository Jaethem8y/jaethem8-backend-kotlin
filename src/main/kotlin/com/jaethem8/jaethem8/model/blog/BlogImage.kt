package com.jaethem8.jaethem8.model.blog

import com.fasterxml.jackson.annotation.JsonBackReference
import com.jaethem8.jaethem8.model.Image
import javax.persistence.*

@Entity
@Table(name = "blog_image")
data class BlogImage(
        override var id: Long?,
        override var image: String?,
        override var location: Int?,
        @ManyToOne(cascade = [CascadeType.PERSIST])
        @JsonBackReference
        @JoinColumn(name = "blog_content_id")
        var blogContent: BlogContent? = null
) : Image(id, image, location)
