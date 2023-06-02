package com.bushelpowered.william.pokedex.repos

import com.bushelpowered.william.pokedex.data.Type
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface TypeRepo: PagingAndSortingRepository<Type, Int> {
    fun findByType(type: String): Type
}