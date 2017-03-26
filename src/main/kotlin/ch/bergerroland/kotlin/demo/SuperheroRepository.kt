package ch.bergerroland.kotlin.demo

import org.springframework.data.jpa.repository.JpaRepository

interface SuperheroRepository : JpaRepository<Superhero, Long>