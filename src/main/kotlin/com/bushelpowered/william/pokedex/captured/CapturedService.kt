package com.bushelpowered.william.pokedex.captured

import com.bushelpowered.william.pokedex.pokemon.Pokemon
import com.bushelpowered.william.pokedex.pokemon.PokemonRepo
import com.bushelpowered.william.pokedex.trainer.Trainer
import com.bushelpowered.william.pokedex.trainer.TrainerRepo
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*
import kotlin.collections.ArrayList

@Service
class CapturedService(val repo: CapturedRepo, val trainerRepo: TrainerRepo, val pokemonRepo: PokemonRepo) {
    fun getAllCaptured(): List<Captured> = repo.findAll()

    fun findCaptured(id: Int): Optional<Captured> = repo.findById(id)

    fun create(captured: Captured): Captured {
        val capturedList = repo.findAll()

        val trainerList = trainerRepo.findAll()

        //throws conflict if pokemon has already been captured by trainer
        for (item in capturedList) {
            if (item.pokemonId == captured.pokemonId && item.trainerId == captured.trainerId) {
                throw ResponseStatusException(HttpStatus.CONFLICT)
            }
        }

        //throws conflict if pokemon does not exist
        if (captured.pokemonId > 553 || captured.pokemonId < 0)
            throw ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY)


        //throws conflict if trainer does not exist
        if (trainerList.size < captured.trainerId)
            throw ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY)


        return repo.save(captured)

    }

    fun capturedInfo(id: Int): List<Pokemon> {

        val capturedList = repo.findAll()
        val trainerPokemon = ArrayList<Int>()


        //checks if trainer exists
        //throws conflict if trainer does not exist
        var exists = false
        for (item in capturedList) {
            if (item.trainerId == id.toLong()) {
                exists = true
            }
        }
        if (exists) {
        } else
            throw ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY)


        //grab pokemon by trainer id
        //put pokemon id in a list
        for (item in capturedList) {
            if (item.trainerId == id.toLong()) {
                trainerPokemon.add(item.pokemonId.toInt())
            }
        }


        return pokemonRepo.findAllById(trainerPokemon)
    }
}

