package com.bushelpowered.william.pokedex.data

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "type")
data class Type(
    @Id
    val id: Int,
    @Column(name = "type")
    val type:String,
)