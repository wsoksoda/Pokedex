package com.bushelpowered.william.pokedex.trainer

import jakarta.persistence.*

@Entity
@Table(name = "trainer")
data class Trainer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    val id: Long,

    @Column(name = "username")
    val username: String,

    @Column(name="password")
    val password: String,

    @Column(name="color")
    val color:String

)

