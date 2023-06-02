package com.bushelpowered.william.pokedex.data

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "trainer")
data class Trainer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    val id: Int,

    @Column(name = "username")
    val username: String,

    @Column(name="password")
    val password: String,

    @Column(name="color")
    val color:String

)

