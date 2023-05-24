package com.bushelpowered.william.pokedex.trainer

import com.bushelpowered.william.pokedex.pokemon.Pokemon
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class TrainerService(val repo:TrainerRepo) {
    fun create(trainer: Trainer): Trainer =
        repo.save(trainer)
}