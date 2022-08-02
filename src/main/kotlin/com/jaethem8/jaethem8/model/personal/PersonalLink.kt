package com.jaethem8.jaethem8.model.personal

import com.fasterxml.jackson.annotation.JsonBackReference
import com.jaethem8.jaethem8.model.Link
import javax.persistence.*

@Entity
@Table(name = "personal_link")
data class PersonalLink(
        override var id: Long? = 0,
        override var tag: String? = null,
        override var link: String? = null,
        override var location: Int? = null,
        @ManyToOne(cascade = [CascadeType.PERSIST])
        @JsonBackReference
        @JoinColumn(name = "personal_content_id")
        var personalContent: PersonalContent? = null
) : Link(id, tag, link, location)
