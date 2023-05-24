package com.bushelpowered.william.pokedex.trainer


import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException.UnprocessableEntity
import org.springframework.web.server.ResponseStatusException
import java.net.http.HttpResponse

@Service
class TrainerService(val repo:TrainerRepo) {
    fun create(trainer: Trainer): Trainer{
        //throws error if trainer username already exists
        val trainers = repo.findAll()
        for(names in trainers){
            if (names.username == trainer.username){
                throw ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY)
            }
        }
        return repo.save(trainer)
    }
}