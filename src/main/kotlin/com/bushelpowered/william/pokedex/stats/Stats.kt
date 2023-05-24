package com.bushelpowered.william.pokedex.stats


import jakarta.persistence.*

@Entity
@Table(name = "stats")
data class Stats(
    @Id val id: Int,
    val hp: Int,
    val speed: Int,
    val attack: Int,
    val defense : Int,
    val specialAttack: Int,
    val specialDefense: Int
)