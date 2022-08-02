package com.jaethem8.jaethem8.model.blog

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "blog_post")
data class BlogPost(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: Long? = 0,
    @Column(name = "title", unique = true)
    var title: String? = null,
    @Column(name = "pub_date")
    var pubDate: Date? = null,
    @Column(name = "role")
    var role: String? = null,
    @Column(name = "frontend")
    var frontend: String? = null,
    @Column(name = "backend")
    var backend: String? = null,
    @Column(name = "general")
    var general: String? = null,
    @JsonManagedReference
    @OneToMany(mappedBy = "blogPost", cascade = [CascadeType.ALL])
    var blogContents: List<BlogContent> = mutableListOf(),
)