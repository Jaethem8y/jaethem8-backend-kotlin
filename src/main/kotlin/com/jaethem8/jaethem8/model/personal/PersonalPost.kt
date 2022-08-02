package com.jaethem8.jaethem8.model.personal

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "personal_post")
data class PersonalPost(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: Long? = 0,
    @Column(name = "title", unique = true)
    var title: String? = null,
    @Column(name = "pub_date")
    var pubDate: Date? = null,
    @JsonManagedReference
    @OneToMany(mappedBy = "personalPost", cascade = [CascadeType.ALL])
    var personalContents: List<PersonalContent> = mutableListOf(),
)