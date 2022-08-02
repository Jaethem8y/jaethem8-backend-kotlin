package com.jaethem8.jaethem8.model.study

import com.fasterxml.jackson.annotation.JsonBackReference
import com.jaethem8.jaethem8.model.Link
import javax.persistence.*

@Entity
@Table(name = "study_link")
data class StudyLink(
        override var id: Long?,
        override var tag: String?,
        override var link: String?,
        override var location: Int?,
        @ManyToOne(cascade = [CascadeType.PERSIST])
        @JsonBackReference
        @JoinColumn(name = "study_content_id")
        var studyContent: StudyContent? = null
) : Link(id, tag, link, location)
