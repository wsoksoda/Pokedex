package com.bushelpowered.william.pokedex.data

data class SaveCapturedRequest(
    var trainerId: Int,
    val pokemonId: Int
)

fun SaveCapturedRequest.toCaptured() = Captured(
    trainerId = trainerId,
    pokemonId = pokemonId
)