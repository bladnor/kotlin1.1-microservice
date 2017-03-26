import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ApplicationTest {
    @Test
    fun printHelloTest() {
        assertEquals(Application().printHello(), "Hello")
    }
}