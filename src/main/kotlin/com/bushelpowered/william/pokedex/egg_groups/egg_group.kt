package com.bushelpowered.william.pokedex.egg_groups

import jakarta.persistence.*

@Entity
@Table(name = "egg_group")
data class EggGroups(
    @Id
    val id: Int,
    val egg_group:String,
)
