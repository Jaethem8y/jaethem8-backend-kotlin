package com.jaethem8.jaethem8.model.personal

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.jaethem8.jaethem8.model.Content
import javax.persistence.*

@Entity
@Table(name = "personal_content")
data class PersonalContent(
        override var id: Long?,
        override var location: Int?,
        override var header: String? = null,
        override var content: String? = null,
        @ManyToOne(cascade = [CascadeType.PERSIST])
        @JsonBackReference
        @JoinColumn(name = "personal_post_id")
        var personalPost: PersonalPost?,
        @JsonManagedReference
        @OneToMany(mappedBy = "personalContent", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        var personalImages: Set<PersonalImage> = hashSetOf(),
        @JsonManagedReference
        @OneToMany(mappedBy = "personalContent", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        var personalLinks: Set<PersonalLink> = hashSetOf()
) : Content(id, location, header, content)
