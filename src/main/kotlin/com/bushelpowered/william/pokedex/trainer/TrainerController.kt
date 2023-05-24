package com.bushelpowered.william.pokedex.trainer


import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("api/trainers")
@RestController
public class TrainerController (val service: TrainerService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveTrainer(@RequestBody trainer: Trainer): Trainer =
        service.create(trainer)
}