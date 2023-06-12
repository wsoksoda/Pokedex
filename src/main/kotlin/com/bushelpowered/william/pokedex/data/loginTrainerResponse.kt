package com.bushelpowered.william.pokedex.data

data class LoginTrainerResponse(
    val id: Int = 0,
    val username: String,
    val color: String
)

fun Trainer.toLoginTrainerResponse() = LoginTrainerResponse(
    id = id,
    username = username,
    color = color
)