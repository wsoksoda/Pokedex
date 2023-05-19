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

    @GetMapping
    fun getAllTrainers() = service.getAll()

//    @PatchMapping("login")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    fun login(@RequestBody username : String, password: String): Trainer =
//        service.login(username, password)
}