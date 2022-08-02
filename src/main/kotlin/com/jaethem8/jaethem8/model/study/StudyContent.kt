package com.jaethem8.jaethem8.model.study

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "study_content")
data class StudyContent(
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
    var code: String? = "",
    @ManyToOne(cascade = [CascadeType.ALL])
    @JsonBackReference
    @JoinColumn(name = "study_post_id")
    var studyPost: StudyPost? = null,
)