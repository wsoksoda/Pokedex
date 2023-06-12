package com.bushelpowered.william.pokedex.services


import com.bushelpowered.william.pokedex.data.Trainer
import com.bushelpowered.william.pokedex.exceptions.TrainerUsernameTaken
import com.bushelpowered.william.pokedex.exceptions.UsernameOrPasswordIncorrect
import com.bushelpowered.william.pokedex.repos.TrainerRepo
import org.springframework.stereotype.Service

@Service
class TrainerService(val repo: TrainerRepo) {
    fun create(trainer: Trainer): Trainer {
        when (repo.existsByUsername(trainer.username)) {
            true -> throw TrainerUsernameTaken()
            else -> return repo.save(trainer)
        }
    }

    fun login(username: String, password: String): Trainer {
        val exists = repo.existsByUsernameAndPassword(username, password)
        val trainer = repo.findByUsernameAndPassword(username, password)
        when (exists) {
            true -> return trainer
            else -> throw UsernameOrPasswordIncorrect()
        }
    }

}