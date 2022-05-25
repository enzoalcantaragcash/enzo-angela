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
    fun checkDifferentImplementationOfInitialize() {
        val gameA = Cricket()
        val gameB = Football()
        assertFalse(gameA.initialize() == gameB.initialize())
    }

    @Test
    fun checkDifferentImplementationOfStartPlay() {
        val gameA = Cricket()
        val gameB = Football()
        assertFalse(gameA.startPlay() == gameB.startPlay())
    }

    @Test
    fun checkDifferentImplementationOfEndPlay() {
        val gameA = Cricket()
        val gameB = Football()
        assertFalse(gameA.endPlay() == gameB.endPlay())
    }
}