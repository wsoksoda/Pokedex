package com.bushelpowered.william.pokedex.captured

import com.bushelpowered.william.pokedex.pokemon.service
import com.bushelpowered.william.pokedex.trainer.Trainer
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("api/captured")
@RestController
public class CapturedController (val service: CapturedService) {

    @GetMapping
    fun getAllCaptured() = service.getAllCaptured()

    @GetMapping("{id}")
    fun getAllCapturedById(@PathVariable id:Int) = service.findCaptured(id)

    @GetMapping("info/{id}")
    fun capturedInfo(@PathVariable id:Int) = service.capturedInfo(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveTrainer(@RequestBody captured: Captured): Captured =
        service.create(captured)
}