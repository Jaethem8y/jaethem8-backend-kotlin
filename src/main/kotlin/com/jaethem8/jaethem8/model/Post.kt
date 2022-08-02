package com.jaethem8.jaethem8.model

import java.sql.Timestamp
import javax.persistence.*

@MappedSuperclass
abstract class Post(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        open var id: Long? = 0,
        @Column(name = "title", unique = true)
        open var title: String? = null,
        @Lob
        @Column(name = "description", columnDefinition = "BLOB")
        open var description: String,
        @Column(name = "pub_date")
        open var pubDate: Timestamp? = null,
)