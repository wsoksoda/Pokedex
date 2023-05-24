package com.bushelpowered.william.pokedex.stats

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StatsRepo: JpaRepository<Stats, Int>