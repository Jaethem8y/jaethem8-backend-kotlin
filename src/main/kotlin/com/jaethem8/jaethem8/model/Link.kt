package com.jaethem8.jaethem8.model

import javax.persistence.*

@MappedSuperclass
abstract class Link(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        open var id: Long? = 0,
        @Column(name = "title")
        open var tag: String? = null,
        @Column(name = "link")
        open var link: String? = null,
        @Column(name = "location")
        open var location: Int? = 0
)