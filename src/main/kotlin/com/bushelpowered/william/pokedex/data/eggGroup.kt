package com.bushelpowered.william.pokedex.data

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "egg_group")
data class EggGroup(
    @Id
    val id: Int,
    val eggGroup:String,
)
