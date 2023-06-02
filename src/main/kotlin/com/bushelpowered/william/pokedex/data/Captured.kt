package com.bushelpowered.william.pokedex.data

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


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
