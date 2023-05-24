package com.bushelpowered.william.pokedex.types

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TypesRepo: JpaRepository<PokemonTypes, Int>