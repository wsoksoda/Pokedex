package com.bushelpowered.william.pokedex.repos

import com.bushelpowered.william.pokedex.data.Captured
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CapturedRepo: JpaRepository<Captured,Int>{

    fun existsByPokemonIdAndTrainerId(pokemonId:Int, trainerId: Int): Boolean

    fun findByTrainerId(trainerId:Int): List<Captured>
}
