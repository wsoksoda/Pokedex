package com.bushelpowered.william.pokedex.repos

import com.bushelpowered.william.pokedex.data.Ability
import com.bushelpowered.william.pokedex.data.EggGroup
import com.bushelpowered.william.pokedex.data.Pokemon
import com.bushelpowered.william.pokedex.data.Type
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository

interface PokemonRepo: PagingAndSortingRepository<Pokemon, Int>{
    fun findById(id:Int): Pokemon
    fun findByName(name:String): Pokemon
   fun findByGenusContainingOrderByGenus(genus:String, pageable: PageRequest):Page<Pokemon>

   fun findByAbility(ability: Ability) : List<Pokemon>

   fun findByType(type: Type): List<Pokemon>

   fun findByEggGroup(eggGroups: EggGroup): List<Pokemon>

   fun existsById(id:Int): Boolean
   fun findAllByIdIn(id:List<Int>):  List<Pokemon>
}




