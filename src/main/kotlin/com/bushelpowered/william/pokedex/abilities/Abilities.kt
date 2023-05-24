package com.bushelpowered.william.pokedex.abilities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "abilities")
data class Abilities(
    @Id
    val id: Int,
    val ability:String,
)
