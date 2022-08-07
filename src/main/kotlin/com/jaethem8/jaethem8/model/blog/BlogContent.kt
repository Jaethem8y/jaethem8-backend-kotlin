package com.jaethem8.jaethem8.model.blog

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.jaethem8.jaethem8.model.Content
import javax.persistence.*

@Entity
@Table(name = "blog_content")
data class BlogContent(
        override var id: Long? = 0,
        override var location: Int? = null,
        override var header: String? = null,
        override var content: String? = null,
        @ManyToOne(cascade = [CascadeType.PERSIST])
        @JsonBackReference
        @JoinColumn(name = "blog_post_id")
        var blogPost: BlogPost? = null,
        @JsonManagedReference
        @OneToMany(mappedBy = "blogContent", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        var blogImages: List<BlogImage> = mutableListOf(),
        @JsonManagedReference
        @OneToMany(mappedBy = "blogContent", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        var blogLinks: List<BlogLink> = mutableListOf()
) : Content(id, location, header, content)
