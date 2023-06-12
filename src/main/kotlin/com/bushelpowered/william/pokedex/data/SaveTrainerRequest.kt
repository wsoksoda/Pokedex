package com.bushelpowered.william.pokedex.data

data class SaveTrainerRequest(
    val username: String,
    val password: String,
    val color: String
)

fun SaveTrainerRequest.toTrainer() = Trainer(
    username = username,
    password = password,
    color = color
)
