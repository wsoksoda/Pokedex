package com.bushelpowered.william.pokedex.data

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "ability")
data class Ability(
    @Id
    val id: Int,
    val ability:String,
)
