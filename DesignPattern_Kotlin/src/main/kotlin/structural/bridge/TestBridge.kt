package structural.bridge

import org.junit.Assert.*
import org.junit.Test

class TestBridge {
    @Test
    fun checkMacbookCheapKeyboardOutput() {
        val macbookWithCheapKeyboard = Macbook(CheapKeyboard())
        val expected = "cheap keyboard"
        assertEquals(expected, macbookWithCheapKeyboard.printToScreen().toString())
    }

    @Test
    fun checkMacbookExpensiveKeyboardOutput() {
        val macbookWithExpensiveKeyboard = Macbook(ExpensiveKeyboard())
        val expected = "expensive keyboard"
        assertEquals(expected, macbookWithExpensiveKeyboard.printToScreen().toString())
    }
}