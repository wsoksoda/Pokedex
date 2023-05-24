package com.bushelpowered.william.pokedex.pokemon


import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@RequestMapping("api/pokemon")
@RestController
public class PokemonController (val service: service){


    @GetMapping()
    fun getAllPokemon(@RequestParam(defaultValue = "1") offset: Int, @RequestParam(defaultValue = "10")pageSize: Int) = service.getAll(offset-1,pageSize)

    @GetMapping("{id}")
    fun getPokemon( @PathVariable id: Int) = service.getById(id)

}
