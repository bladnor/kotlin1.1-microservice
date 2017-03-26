package ch.bergerroland.kotlin.demo

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun findAll() {
        val content = """[{"name":"elektra","superpower":"combat","id":1},{"name":"loki","superpower":"shape-shifting","id":2},{"name":"superman","superpower":"flight","id":3},{"name":"batmann","superpower":"","id":4},{"name":"","superpower":"","id":5}]"""
        assertEquals(content, restTemplate.getForEntity("/superheroes", String::class.java).body)
    }

}