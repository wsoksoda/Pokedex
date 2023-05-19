package com.bushelpowered.william.pokedex.pokemon

import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class service(val repo: PokemonRepo){

    fun getAll(): List<Pokemon> = repo.findAll()

    fun getById(id: Int): Pokemon = repo.findByIdOrNull(id) ?:
    throw ResponseStatusException(HttpStatus.NOT_FOUND)


}