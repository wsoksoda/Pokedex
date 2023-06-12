package com.bushelpowered.william.pokedex.controllers

import com.bushelpowered.william.pokedex.services.PokemonService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@CrossOrigin(origins = ["http://localhost:5173/", "http://localhost:3000/"], maxAge = 3600)
@RequestMapping("api/pokemon")
@RestController
class PokemonController(val service: PokemonService) {


    @GetMapping()
    fun getAllPokemon(
        @RequestParam(defaultValue = "1") offset: Int,
        @RequestParam(defaultValue = "10") pageSize: Int
    ) = service.getAll(offset - 1, pageSize)

    @GetMapping("{id}")
    fun getPokemon(
        @PathVariable id: Int
    ) = service.getById(id)

    @GetMapping("/name")
    fun getPokemonByNameContaining(
        @RequestParam name: String, @RequestParam(defaultValue = "1") offset: Int,
        @RequestParam(defaultValue = "10") pageSize: Int
    ) = service.getByName(name, offset - 1, pageSize)

    @GetMapping("/ability")
    fun getPokemonByAbility(
        @RequestParam(defaultValue = " overgrow") ability: String, @RequestParam(defaultValue = "1") offset: Int,
        @RequestParam(defaultValue = "10") pageSize: Int
    ) = service.getByAbility(ability, offset - 1, pageSize)

    @GetMapping("/egg")
    fun getPokemonByEggGroup(
        @RequestParam(defaultValue = "") eggGroup: String, @RequestParam(defaultValue = "1") offset: Int,
        @RequestParam(defaultValue = "10") pageSize: Int
    ) = service.getByEggGroup(eggGroup, offset - 1, pageSize)

    @GetMapping("/type")
    fun getPokemonByType(
        @RequestParam(defaultValue = "") type: String, @RequestParam(defaultValue = "1") offset: Int,
        @RequestParam(defaultValue = "10") pageSize: Int
    ) = service.getByType(type, offset - 1, pageSize)

    @GetMapping("/genus")
    fun getPokemonByGenus(
        @RequestParam genus: String, @RequestParam(defaultValue = "1") offset: Int,
        @RequestParam(defaultValue = "10") pageSize: Int
    ) = service.getByGenus(genus, offset - 1, pageSize)


}
