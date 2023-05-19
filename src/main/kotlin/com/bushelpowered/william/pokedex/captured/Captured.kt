package com.bushelpowered.william.pokedex.captured

import jakarta.persistence.*

@Entity
@Table(name = "captured")
data class Captured(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    val id: Long,

    @Column(name="trainer_id")
    var trainerId: Long,


    @Column(name="pokemon_id")
    val pokemonId: Long
)
