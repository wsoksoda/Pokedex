package com.bushelpowered.william.pokedex.connectionDataClasses

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "egg_group_connection")
data class Egg_GroupConn(
    @Id
    val id: Int,
    val pokemonId: Int,
    val EggGroupId: Int,
)