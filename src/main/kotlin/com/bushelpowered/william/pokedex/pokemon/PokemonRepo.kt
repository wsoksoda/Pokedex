package com.bushelpowered.william.pokedex.pokemon

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface PokemonRepo: JpaRepository<Pokemon,Int>

interface PokemonPageRepo: PagingAndSortingRepository<Pokemon, Int>




