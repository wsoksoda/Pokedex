package com.bushelpowered.william.pokedex.repos

import com.bushelpowered.william.pokedex.data.EggGroup
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface EggGroupRepo: PagingAndSortingRepository<EggGroup, Int> {
    fun findByEggGroup(eggGroup: String): EggGroup
}