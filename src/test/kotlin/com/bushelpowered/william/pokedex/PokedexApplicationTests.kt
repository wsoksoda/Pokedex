package com.bushelpowered.william.pokedex

import com.bushelpowered.william.pokedex.data.Ability
import com.bushelpowered.william.pokedex.data.EggGroup
import com.bushelpowered.william.pokedex.data.Pokemon
import com.bushelpowered.william.pokedex.data.Stats
import com.bushelpowered.william.pokedex.data.Trainer
import com.bushelpowered.william.pokedex.data.Type
import com.bushelpowered.william.pokedex.repos.AbilityRepo
import com.bushelpowered.william.pokedex.repos.CapturedRepo
import com.bushelpowered.william.pokedex.repos.EggGroupRepo
import com.bushelpowered.william.pokedex.repos.PokemonRepo
import com.bushelpowered.william.pokedex.repos.TrainerRepo
import com.bushelpowered.william.pokedex.repos.TypeRepo
import com.bushelpowered.william.pokedex.services.CapturedService
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


class PokedexApplicationTests {

    @BeforeEach
    fun setUp() {
        clearAllMocks()
        unmockkAll()
    }


    val pokemonPageRepo = mockk<PokemonRepo>()
    val abilityRepo = mockk<AbilityRepo>()
    val capturedRepo = mockk<CapturedRepo>()
    val eggGroupRepo = mockk<EggGroupRepo>()
    val trainerRepo = mockk<TrainerRepo>()
    val typeRepo = mockk<TypeRepo>()
    val pokemonService = mockk<PokemonService>()
    val capturedService = mockk<CapturedService>()
    val trainerService = mockk<TrainerService>()

    @Test
    fun `find by id`() {
        every { pokemonService.getById(1) } returns Pokemon(1,
			"Bulbasaur",
			listOf(Type(1,"poison"), Type(2,"grass")),
			7.0F,
			69.0F,
			listOf(Ability(1,"chlorophyll"),Ability(2,"overgrow")),
			listOf(EggGroup(1,"plant"),EggGroup(2,"monster")),
			Stats(1,45,45,49,49,65,65),
			"Seed Pokémon",
			"Bulbasaur can be seen napping in bright sunlight.\\nThere is a seed on its back. By soaking up the sun’s rays,\\nthe seed grows progressively larger.")

        val result = pokemonService.getById(1)

        verify{pokemonService.getById(1)}
        assertEquals(Pokemon(1,
            "Bulbasaur",
            listOf(Type(1,"poison"), Type(2,"grass")),
            7.0F,
            69.0F,
            listOf(Ability(1,"chlorophyll"),Ability(2,"overgrow")),
            listOf(EggGroup(1,"plant"),EggGroup(2,"monster")),
            Stats(1,45,45,49,49,65,65),
            "Seed Pokémon",
            "Bulbasaur can be seen napping in bright sunlight.\\nThere is a seed on its back. By soaking up the sun’s rays,\\nthe seed grows progressively larger."),result)
    }

//	@Test
//	fun pokemonTests() {
//
//
//
//		val items = listOf(
//			Pokemon(
//			1,
//			"TestPokemon",
//			listOf(Type(1,"TestType1"), Type(2,"TestType2")),
//			1F,
//			1F,
//			listOf(Ability(1,"TestAbility1"),Ability(2,"TestAbility2")),
//			listOf(EggGroup(1,"TestEggGroup1"),EggGroup(2,"TestEggGroup2")),
//			Stats(1,1,1,1,1,1,1),
//			"testGenus",
//			"Test Pokemon"),
//
//			Pokemon(
//				2,
//			"TestPokemon2",
//			listOf(Type(1,"TestType1"), Type(2,"TestType2")),
//			2F,
//			2F,
//			listOf(Ability(1,"TestAbility1"),Ability(2,"TestAbility2")),
//			listOf(EggGroup(1,"TestEggGroup1"),EggGroup(2,"TestEggGroup2")),
//			Stats(2,2,2,2,2,2,2),
//			"testGenus",
//			"Test Pokemon"))
//
//		val pageableResponse = PageImpl(items)
//		every { pokemonPageRepo.findAll(any<Pageable>) } returns pageableResponse
//
//		pokemonPageRepo.findAll()
//
//		verify {  }
//
//		val pokemonService = mockk<PokemonService>()
//
//	}


    @Test
    fun trainerTests() {
        every { trainerService.create(any()) } returns Trainer(100, "TestUsername", "TestPassword", "TestColor")

        val result = trainerService.create(
            Trainer(100, "TestUsername", "TestPassword", "TestColor")
        )

        assertEquals(Trainer(100, "TestUsername", "TestPassword", "TestColor"), result)
    }

}


