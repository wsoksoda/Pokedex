package com.bushelpowered.william.pokedex.data


import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "pokemon")
data class Pokemon(
    @Id
    @Column(name = "id")
    val id: Int,
    val name: String,
    @OneToMany
    @JoinTable(
        name = "type_connection",
        joinColumns = [JoinColumn(name = "pokemonId")],
        inverseJoinColumns = [JoinColumn(name = "typeId")]
    )
    val type: List<Type>,
    val height: Double,
    val weight: Double,
    @OneToMany
    @JoinTable(
        name = "ability_connection",
        joinColumns = [JoinColumn(name = "pokemonId")],
        inverseJoinColumns = [JoinColumn(name = "abilityId")]
    )
    @JoinColumn(name = "pokemonId")
    val ability: List<Ability>,
    @OneToMany
    @JoinTable(
        name = "egg_group_connection",
        joinColumns = [JoinColumn(name = "pokemonId")],
        inverseJoinColumns = [JoinColumn(name = "eggGroupId")]
    )
    @JoinColumn(name = "pokemonId")
    val eggGroup: List<EggGroup>,
    @OneToOne
    @JoinColumn(name = "id")
    val stats: Stats,
    val genus: String,
    val description: String
)


