package behavioral.template

import org.junit.Assert.*
import org.junit.Test

class TestTemplate {
    @Test
    fun checkInstanceOfGame() {
        val gameA = Cricket()
        assertTrue(gameA is Game)

        val gameB = Football()
        assertTrue(gameB is Game)
    }

    @Test
    fun checkDifferentImplementation() {
        val gameA = Cricket()
        val gameB = Football()
        assertFalse(gameA.initialize() == gameB.initialize())
    }
}