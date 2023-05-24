package com.bushelpowered.william.pokedex.captured

import jakarta.persistence.*

@Entity
@Table(name = "captured")
data class Captured(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    val id: Int,
    @Column(name="trainer_id")
    var trainerId: Int,
    @Column(name="pokemon_id")
    val pokemonId: Int
)
