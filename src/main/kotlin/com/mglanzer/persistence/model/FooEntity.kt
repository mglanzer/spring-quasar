package com.mglanzer.persistence.model

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Entity
data class FooEntity (
    val name: String = "",

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
)