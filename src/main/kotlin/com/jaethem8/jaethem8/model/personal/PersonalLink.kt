package com.jaethem8.jaethem8.model.personal

import com.fasterxml.jackson.annotation.JsonBackReference
import com.jaethem8.jaethem8.model.Link
import javax.persistence.*

@Entity
@Table(name = "personal_link")
data class PersonalLink(
        override var id: Long?,
        override var tag: String?,
        override var link: String?,
        override var location: Int?,
        @ManyToOne(cascade = [CascadeType.PERSIST])
        @JsonBackReference
        @JoinColumn(name = "personal_content_id")
        var personalContent: PersonalContent? = null
) : Link(id, tag, link, location)
