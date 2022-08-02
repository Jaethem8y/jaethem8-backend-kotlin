package com.jaethem8.jaethem8.model.study

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "study_post")
class StudyPost(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    var id: Long? = 0,
    @Column(name = "title", unique = true)
    var title: String? = null,
    @Column(name = "pub_date")
    var pubDate: Date? = null,
    @JsonManagedReference
    @OneToMany(mappedBy = "studyPost", cascade = [CascadeType.ALL])
    var studyContents: List<StudyContent> = mutableListOf(),
)