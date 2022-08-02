package com.jaethem8.jaethem8.model

import javax.persistence.*

@MappedSuperclass
abstract class Image(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        open var id: Long? = 0,
        @Column(name = "image")
        open var image: String? = null,
        @Column(name = "location")
        open var location: Int? = 0
)
