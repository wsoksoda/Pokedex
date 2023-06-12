package com.bushelpowered.william.pokedex.controllers

import com.bushelpowered.william.pokedex.data.Captured
import com.bushelpowered.william.pokedex.services.CapturedService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController



@CrossOrigin(origins = ["http://localhost:5173/"], maxAge = 3600)
@RequestMapping("api/captured")
@RestController
class CapturedController (val service: CapturedService) {

    @GetMapping("{id}")
    fun capturedInfo(@PathVariable id:Int) = service.capturedInfo(id)

    @PostMapping
    fun saveCaptured(@RequestBody captured: Captured): Captured {
        ResponseEntity.status(HttpStatus.CREATED).body(
            return service.create(captured)
        )
    }
}