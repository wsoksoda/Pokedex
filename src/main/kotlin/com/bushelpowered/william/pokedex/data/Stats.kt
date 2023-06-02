package com.bushelpowered.william.pokedex.data

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table


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