package com.bushelpowered.william.pokedex.pokemon


import com.bushelpowered.william.pokedex.abilities.Abilities
import com.bushelpowered.william.pokedex.egg_groups.EggGroups
import com.bushelpowered.william.pokedex.stats.Stats
import com.bushelpowered.william.pokedex.types.PokemonTypes
import jakarta.persistence.*

@Entity
@Table(name = "pokemon")
data class Pokemon(
    @Id
    @Column(name = "id")
    val id: Int,
    val name: String,
    @ManyToMany()
    @JoinTable(name = "type_connection",
        joinColumns = [JoinColumn(name ="pokemonId")],
        inverseJoinColumns = [JoinColumn(name = "typeId")])
    val type: List<PokemonTypes>,
    val height: Float,
    val weight: Float,
    @ManyToMany()
    @JoinTable(name = "ability_connection",
        joinColumns = [JoinColumn(name ="pokemonId")],
        inverseJoinColumns = [JoinColumn(name = "abilityId")])
    @JoinColumn(name = "pokemonId")
    val abilities: List<Abilities>,
    @ManyToMany()
    @JoinTable(name = "egg_group_connection",
        joinColumns = [JoinColumn(name ="pokemonId")],
        inverseJoinColumns = [JoinColumn(name = "eggGroupId")])
    @JoinColumn(name = "pokemonId")
    val eggGroups: List<EggGroups>,
    @OneToOne
    @JoinColumn(name = "id")
    val stats: Stats,
    val genus: String,
    val description: String
)


