package com.bushelpowered.william.pokedex.pokemon

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class service(val repo: PokemonRepo, val page: PokemonPageRepo){

    fun getAll(offset: Int, pageSize: Int): Page<Pokemon> {
        return page.findAll(PageRequest.of(offset, pageSize))
    }
    fun getById(id: Int): Pokemon = repo.findByIdOrNull(id) ?:
    throw ResponseStatusException(HttpStatus.NOT_FOUND)



}