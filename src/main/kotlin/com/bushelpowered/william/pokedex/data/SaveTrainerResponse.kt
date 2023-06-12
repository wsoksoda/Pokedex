package com.bushelpowered.william.pokedex.data

data class SaveTrainerResponse(
    val id: Int = 0,
    val username: String,
    val color: String
)

fun Trainer.toSaveTrainerResponse() = SaveTrainerResponse(
    id = id,
    username = username,
    color = color
)