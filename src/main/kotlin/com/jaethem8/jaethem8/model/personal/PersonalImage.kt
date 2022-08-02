package com.jaethem8.jaethem8.model.personal

import com.fasterxml.jackson.annotation.JsonBackReference
import com.jaethem8.jaethem8.model.Image
import javax.persistence.*

@Entity
@Table(name = "personal_image")
data class PersonalImage(
        override var id: Long? = 0,
        override var image: String? = null,
        override var location: Int? = null,
        @ManyToOne(cascade = [CascadeType.PERSIST])
        @JsonBackReference
        @JoinColumn(name = "personal_content_id")
        var personalContent: PersonalContent? = null
) : Image(id, image, location)
