package com.bushelpowered.william.pokedex.connectionDataClasses

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "type_connection")
data class TypeConn(
    @Id
    val id: Int,
    val pokemonId: Int,
    val typeId: Int,
)