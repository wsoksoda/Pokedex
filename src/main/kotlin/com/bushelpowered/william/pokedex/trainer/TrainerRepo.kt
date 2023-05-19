package com.bushelpowered.william.pokedex.trainer

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TrainerRepo: JpaRepository<Trainer,Int>