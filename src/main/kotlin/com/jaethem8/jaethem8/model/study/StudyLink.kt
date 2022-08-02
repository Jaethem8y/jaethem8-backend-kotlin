package com.jaethem8.jaethem8.model.study

import com.fasterxml.jackson.annotation.JsonBackReference
import com.jaethem8.jaethem8.model.Link
import javax.persistence.*

@Entity
@Table(name = "study_link")
data class StudyLink(
        override var id: Long? = 0,
        override var tag: String? = null,
        override var link: String? = null,
        override var location: Int? = null,
        @ManyToOne(cascade = [CascadeType.PERSIST])
        @JsonBackReference
        @JoinColumn(name = "study_content_id")
        var studyContent: StudyContent? = null
) : Link(id, tag, link, location)
