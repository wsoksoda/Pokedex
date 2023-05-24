package com.bushelpowered.william.pokedex.egg_groups

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface egg_groupRepo: JpaRepository<EggGroups, Int>