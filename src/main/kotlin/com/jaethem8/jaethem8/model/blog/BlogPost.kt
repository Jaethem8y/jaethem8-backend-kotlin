package com.jaethem8.jaethem8.model.blog

import com.fasterxml.jackson.annotation.JsonManagedReference
import com.jaethem8.jaethem8.model.Post
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "blog_post")
data class BlogPost(
        override var id: Long? = 0,
        override var title: String? = null,
        override var description: String? = null,
        override var pubDate: Timestamp? = null,
        @Column(name = "role")
        var role: String? = null,
        @Column(name = "frontend")
        var frontend: String? = null,
        @Column(name = "backend")
        var backend: String? = null,
        @Column(name = "general")
        var general: String? = null,
        @JsonManagedReference
        @OneToMany(mappedBy = "blogPost", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        var blogContents: List<BlogContent> = mutableListOf()
) : Post(id, title, description, pubDate)
