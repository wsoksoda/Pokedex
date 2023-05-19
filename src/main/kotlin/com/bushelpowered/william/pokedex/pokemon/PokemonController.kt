package com.bushelpowered.william.pokedex.pokemon


import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping

@RequestMapping("api/pokemon")
@RestController
public class PokemonController (val service: service){


    @GetMapping
    fun getAllPokemon() = service.getAll()

    @GetMapping("{id}")
    fun getPokemon( @PathVariable id: Int) = service.getById(id)
}
