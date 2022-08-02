package com.jaethem8.jaethem8.model.blog

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "blog_content")
data class BlogContent(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long = 0,
    @Column(name = "post_name")
    var postName: String? = null,
    @Column(name = "location")
    var location: Int = 0,
    @Column(name = "content", length = 16777215, columnDefinition = "mediumtext")
    var content: String? = null,
    @Lob
    @Column(name = "image", length = 16777215, columnDefinition = "mediumtext")
    var image: String? = null,
    @Column(name = "code", length = 16777215, columnDefinition = "mediumtext")
    var code: String? = null,
    @ManyToOne(cascade = [CascadeType.ALL])
    @JsonBackReference
    @JoinColumn(name = "blog_post_id")
    var blogPost: BlogPost? = null,
)