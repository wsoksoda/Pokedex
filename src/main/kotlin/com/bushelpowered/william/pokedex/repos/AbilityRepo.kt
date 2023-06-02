package com.bushelpowered.william.pokedex.repos

import com.bushelpowered.william.pokedex.data.Ability
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface AbilityRepo: PagingAndSortingRepository<Ability, Int> {
fun findByAbility(ability:String): Ability
}