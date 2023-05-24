package com.bushelpowered.william.pokedex.abilities

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AbilityRepo: JpaRepository<Abilities, Int>