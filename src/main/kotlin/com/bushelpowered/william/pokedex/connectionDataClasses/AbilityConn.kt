package com.bushelpowered.william.pokedex.connectionDataClasses

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "ability_connection")
data class AbilityConn(
    @Id
    val id: Int,
    val pokemonId: Int,
    val abilityId: Int,
)