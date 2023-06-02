package com.bushelpowered.william.pokedex.controllers


import com.bushelpowered.william.pokedex.data.Trainer
import com.bushelpowered.william.pokedex.services.TrainerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:5173/"], maxAge = 3600)
@RequestMapping("api/trainers")
@RestController
class TrainerController(val service: TrainerService) {

    @PostMapping
    fun saveTrainer(@RequestBody trainer: Trainer): ResponseEntity<Trainer> {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            service.create(trainer)
        )
    }

    @PostMapping("login")
    fun login(@RequestParam username: String, @RequestParam password: String): ResponseEntity<Trainer> {
        return ResponseEntity.status(HttpStatus.CREATED).body(
            service.login(username, password)
        )
    }
}