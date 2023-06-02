package com.bushelpowered.william.pokedex.services

import com.bushelpowered.william.pokedex.data.Pokemon
import com.bushelpowered.william.pokedex.repos.AbilityRepo
import com.bushelpowered.william.pokedex.repos.EggGroupRepo
import com.bushelpowered.william.pokedex.repos.PokemonRepo
import com.bushelpowered.william.pokedex.repos.TypeRepo
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service


@Service
class PokemonService(
    val pokemonRepo: PokemonRepo, val abilityRepo: AbilityRepo,
    val typeRepo: TypeRepo, val eggGroupRepo: EggGroupRepo
) {

    fun getAll(offset: Int, pageSize: Int): Page<Pokemon> {
        return pokemonRepo.findAll(PageRequest.of(offset, pageSize))
    }

    fun getById(id: Int): Pokemon = pokemonRepo.findById(id)

    fun getByName(name: String): Pokemon = pokemonRepo.findByName(name)

    fun getByAbility(
        abilityName: String,
        offset: Int,
        pageSize: Int
    ): Page<Pokemon> {
        val ability = abilityRepo.findByAbility(abilityName)
        val pokemonList = pokemonRepo.findByAbility(ability)
        return PageImpl(pokemonList, PageRequest.of(offset, pageSize), pokemonList.size.toLong())
    }

    fun getByType(
        typeName: String,
        offset: Int,
        pageSize: Int
    ): Page<Pokemon> {
        val type = typeRepo.findByType(typeName)
        val pokemonList = pokemonRepo.findByType(type)
        return PageImpl(pokemonList, PageRequest.of(offset, pageSize), pokemonList.size.toLong())
    }

    fun getByEggGroup(
        eggName: String,
        offset: Int,
        pageSize: Int
    ): Page<Pokemon> {
        val eggGroup = eggGroupRepo.findByEggGroup(eggName)
        val pokemonList = pokemonRepo.findByEggGroup(eggGroup)
        return PageImpl(pokemonList, PageRequest.of(offset, pageSize), pokemonList.size.toLong())
    }

    fun getByGenus(genus: String, offset: Int, pageSize: Int): Page<Pokemon> =
        pokemonRepo.findByGenusContainingOrderByGenus(genus, PageRequest.of(offset, pageSize))

}



