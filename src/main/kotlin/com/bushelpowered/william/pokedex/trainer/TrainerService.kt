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

    fun getAll(): List<Trainer> = repo.findAll()

//    fun login(username: String, password: String): Trainer {
//        val trainerList = repo.findAll()
//
//        for(item in trainerList){
//            if(username == item.username && password == item.password){
//                return item
//            }
//        }
//
//        throw ResponseStatusException(HttpStatus.NOT_FOUND)
//    }

}