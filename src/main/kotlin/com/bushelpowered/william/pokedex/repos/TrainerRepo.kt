package com.bushelpowered.william.pokedex.repos

import com.bushelpowered.william.pokedex.data.Trainer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TrainerRepo: JpaRepository<Trainer,Int>{
    fun existsByUsername(username:String):Boolean

    fun existsByUsernameAndPassword(username: String, password:String): Boolean

    fun findByUsernameAndPassword(username: String, password:String):Trainer

    override fun existsById(id:Int): Boolean
}