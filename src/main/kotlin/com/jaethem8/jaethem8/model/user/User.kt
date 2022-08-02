package com.jaethem8.jaethem8.model.user

import javax.persistence.*

@Entity
@Table(name = "user")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: Long? = null,
    @Column(name = "name")
    var name: String? = null,
    @Column(name = "username")
    var username: String? = null,
    @Lob
    @Column(name = "password")
    var password: String? = null,
    @Column(name = "role")
    var role: String? = null
)