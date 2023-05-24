package com.bushelpowered.william.pokedex.types

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "types")
data class PokemonTypes(
    @Id
    val id: Int,
    val type:String,
)