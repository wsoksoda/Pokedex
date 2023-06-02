package com.bushelpowered.william.pokedex.services

import com.bushelpowered.william.pokedex.data.Captured
import com.bushelpowered.william.pokedex.data.Pokemon
import com.bushelpowered.william.pokedex.repos.CapturedRepo
import com.bushelpowered.william.pokedex.repos.PokemonRepo
import com.bushelpowered.william.pokedex.repos.TrainerRepo
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service

@Service
class CapturedService(val capturedRepo: CapturedRepo, val trainerRepo: TrainerRepo, val pokemonRepo: PokemonRepo) {



    fun capturedInfo(id: Int): List<Pokemon> {
        when (!trainerRepo.existsById(id)) {
            true -> throw NotFoundException()
            else -> return pokemonRepo.findAllByIdIn(capturedRepo.findByTrainerId(id).map { it.pokemonId })
        }
    }

    fun create(captured: Captured): Captured {
        when (!(trainerRepo.existsById(captured.trainerId) && pokemonRepo.existsById(captured.pokemonId)) ||
                (capturedRepo.existsByPokemonIdAndTrainerId(captured.pokemonId, captured.trainerId))) {
            true -> throw IllegalArgumentException()
            else -> return capturedRepo.save(captured)
        }
    }
}

