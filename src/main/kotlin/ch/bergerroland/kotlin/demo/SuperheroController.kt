package ch.bergerroland.kotlin.demo


import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = "/superheroes")
class SuperheroController @Autowired constructor(val superheroRepository: SuperheroRepository) {

    val logger: Logger =  LoggerFactory.getLogger(SuperheroController::class.java)

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun findAll(): List<Superhero> = superheroRepository.findAll()

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun addSuperhero(@RequestBody superhero: Superhero): Superhero {
        val persistedHero = superheroRepository.save(superhero)
        logger.debug("persisting: $persistedHero")
        return persistedHero
    }

//    @Autowired
//    lateinit var superheroRepo : SuperheroRepository
}