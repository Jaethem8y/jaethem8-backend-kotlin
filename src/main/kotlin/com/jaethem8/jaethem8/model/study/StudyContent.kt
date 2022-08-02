package com.jaethem8.jaethem8.model.study

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.jaethem8.jaethem8.model.Content
import javax.persistence.*

@Entity
@Table(name = "study_content")
data class StudyContent(
        override var id: Long? = 0,
        override var location: Int? = null,
        override var header: String? = null,
        override var content: String? = null,
        @ManyToOne(cascade = [CascadeType.PERSIST])
        @JsonBackReference
        @JoinColumn(name = "study_post_id")
        var studyPost: StudyPost? = null,
        @JsonManagedReference
        @OneToMany(mappedBy = "studyContent", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        var studyImages: Set<StudyImage> = hashSetOf(),
        @JsonManagedReference
        @OneToMany(mappedBy = "studyContent", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        var studyLinks: Set<StudyLink> = hashSetOf()
) : Content(id, location, header, content)
