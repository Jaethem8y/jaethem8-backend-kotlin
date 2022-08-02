package com.jaethem8.jaethem8.model

import javax.persistence.*

@MappedSuperclass
abstract class Content(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        open var id: Long? = 0,
        @Column(name = "location")
        open var location: Int? = null,
        @Column(name = "header")
        open var header: String? = null,
        @Lob
        @Column(name = "content", columnDefinition = "BLOB")
        open var content: String? = null,
)