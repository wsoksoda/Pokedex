package com.bushelpowered.william.pokedex.captured

import com.bushelpowered.william.pokedex.pokemon.Pokemon
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CapturedRepo: JpaRepository<Captured,Int>{
    @Query()
}