package com.jaethem8.jaethem8.model.study

import com.fasterxml.jackson.annotation.JsonBackReference
import com.jaethem8.jaethem8.model.Image
import javax.persistence.*

@Entity
@Table(name = "study_image")
data class StudyImage(
        override var id: Long? = 0,
        override var image: String? = null,
        override var location: Int? = null,
        @ManyToOne(cascade = [CascadeType.PERSIST])
        @JsonBackReference
        @JoinColumn(name = "study_content_id")
        var studyContent: StudyContent? = null
) : Image(id, image, location)
