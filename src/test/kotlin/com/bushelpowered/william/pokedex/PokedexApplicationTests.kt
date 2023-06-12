package com.bushelpowered.william.pokedex

import com.bushelpowered.william.pokedex.data.Ability
import com.bushelpowered.william.pokedex.data.EggGroup
import com.bushelpowered.william.pokedex.data.Pokemon
import com.bushelpowered.william.pokedex.data.Stats
import com.bushelpowered.william.pokedex.data.Trainer
import com.bushelpowered.william.pokedex.data.Type
import com.bushelpowered.william.pokedex.services.PokemonService
import com.bushelpowered.william.pokedex.services.TrainerService
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.unmockkAll
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.data.domain.PageImpl


class PokedexApplicationTests {

    @BeforeEach
    fun setUp() {
        clearAllMocks()
        unmockkAll()
    }

    val pokemonService = mockk<PokemonService>()
    val trainerService = mockk<TrainerService>()

    @Test
    fun `find by id`() {
        every { pokemonService.getById(1) } returns Pokemon(
            1,
            "Bulbasaur",
            listOf(Type(1, "poison"), Type(2, "grass")),
            7.0,
            69.0,
            listOf(Ability(1, "chlorophyll"), Ability(2, "overgrow")),
            listOf(EggGroup(1, "plant"), EggGroup(2, "monster")),
            Stats(1, 45, 45, 49, 49, 65, 65),
            "Seed Pokémon",
            "Bulbasaur can be seen napping in bright sunlight.\\nThere is a seed on its back. By " +
                    "soaking up the sun’s rays,\\nthe seed grows progressively larger."
        )
        val result = pokemonService.getById(1)
        verify { pokemonService.getById(1) }
        assertEquals(
            Pokemon(
                1,
                "Bulbasaur",
                listOf(Type(1, "poison"), Type(2, "grass")),
                7.0,
                69.0,
                listOf(Ability(1, "chlorophyll"), Ability(2, "overgrow")),
                listOf(EggGroup(1, "plant"), EggGroup(2, "monster")),
                Stats(1, 45, 45, 49, 49, 65, 65),
                "Seed Pokémon",
                "Bulbasaur can be seen napping in bright sunlight.\\nThere is a seed on its back. " +
                        "By soaking up the sun’s rays,\\nthe seed grows progressively larger."
            ), result
        )
    }

    @Test
    fun `pageable response`() {
        val items = listOf(
            Pokemon(
                1,
                "Bulbasaur",
                listOf(Type(1, "poison"), Type(2, "grass")),
                7.0,
                69.0,
                listOf(Ability(1, "chlorophyll"), Ability(2, "overgrow")),
                listOf(EggGroup(1, "plant"), EggGroup(2, "monster")),
                Stats(1, 45, 45, 49, 49, 65, 65),
                "Seed Pokémon",
                "Bulbasaur can be seen napping in bright sunlight.\\nThere is a seed on its back. " +
                        "By soaking up the sun’s rays,\\nthe seed grows progressively larger."
            ), Pokemon(
                2,
                "Ivysaur",
                listOf(Type(1, "poison"), Type(2, "grass")),
                10.0,
                130.0,
                listOf(Ability(1, "chlorophyll"), Ability(2, "overgrow")),
                listOf(EggGroup(1, "plant"), EggGroup(2, "monster")),
                Stats(2, 60, 60, 62, 63, 80, 80),
                "Seed Pokémon",
                "There is a bud on this Pokémon’s back. To support its weight,\\nIvysaur’s legs and trunk" +
                        " grow thick and strong.\\nIf it starts spending more time lying in the sunlight,\\nit’s a " +
                        "sign that the bud will bloom into a large flower soon."
            )
        )
        val pageableResponse = PageImpl(items)
        every { pokemonService.getAll(1, 2) } returns pageableResponse
        val result = pokemonService.getAll(1, 2)
        verify { pokemonService.getAll(1, 2) }
        assertEquals(pageableResponse, result)
    }


    @Test
    fun `register and login a trainer`() {
        every { trainerService.create(any()) } returns Trainer(
            100, "TestUsername", "TestPassword", "TestColor")

        val create = trainerService.create(
            Trainer(100, "TestUsername", "TestPassword", "TestColor")
        )

        assertEquals(Trainer(100, "TestUsername", "TestPassword", "TestColor"), create)

        every { trainerService.login("TestUsername", "TestPassword") } returns Trainer(
            100, "TestUsername", "TestPassword", "TestColor"
        )

        val login = trainerService.login("TestUsername", "TestPassword")

        assertEquals(Trainer(100, "TestUsername", "TestPassword", "TestColor"), login)
    }


}


