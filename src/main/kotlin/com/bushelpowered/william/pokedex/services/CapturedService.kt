package com.bushelpowered.william.pokedex.services

import com.bushelpowered.william.pokedex.data.Captured
import com.bushelpowered.william.pokedex.data.Pokemon
import com.bushelpowered.william.pokedex.exceptions.PokemonOrTrainerDoesNotExist
import com.bushelpowered.william.pokedex.exceptions.TrainerDoesNotExist
import com.bushelpowered.william.pokedex.repos.CapturedRepo
import com.bushelpowered.william.pokedex.repos.PokemonRepo
import com.bushelpowered.william.pokedex.repos.TrainerRepo
import org.springframework.stereotype.Service

@Service
class CapturedService(val capturedRepo: CapturedRepo, val trainerRepo: TrainerRepo, val pokemonRepo: PokemonRepo) {


    fun capturedInfo(id: Int): List<Pokemon> {
        when (!trainerRepo.existsById(id)) {
            true -> throw TrainerDoesNotExist()
            else -> return pokemonRepo.findAllByIdIn(capturedRepo.findByTrainerId(id).map { it.pokemonId })
        }
    }

    fun create(captured: Captured): Captured {
        when (!(trainerRepo.existsById(captured.trainerId) && pokemonRepo.existsById(captured.pokemonId)) ||
                (capturedRepo.existsByPokemonIdAndTrainerId(captured.pokemonId, captured.trainerId))) {
            true -> throw PokemonOrTrainerDoesNotExist()
            else -> return capturedRepo.save(captured)
        }
    }
}

