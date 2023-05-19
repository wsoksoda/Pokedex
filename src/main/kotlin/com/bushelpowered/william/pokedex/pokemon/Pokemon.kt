package com.bushelpowered.william.pokedex.pokemon


import jakarta.persistence.*

@Entity
@Table(name = "pokemon")
data class Pokemon(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)val id: Long,
    val name: String,
    val type: String,
    val height: Float,
    val weight: Float,
    val abilities: String,
    val eggGroups: String,
    val stats: String,
    val genus: String,
    val description:String
)

