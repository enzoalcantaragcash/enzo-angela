package structural.bridge

import org.junit.Assert.*
import org.junit.Test

class TestBridge {
    @Test
    fun checkMacbookCheapKeyboardOutput() {
        val macbookWithCheapKeyboard = Macbook(CheapKeyboard())
        val expected = "cheap keyboard"
        assertEquals(expected, macbookWithCheapKeyboard.printToScreen())
    }

    @Test
    fun checkMacbookExpensiveKeyboardOutput() {
        val macbookWithExpensiveKeyboard = Macbook(ExpensiveKeyboard())
        val expected = "expensive keyboard"
        assertEquals(expected, macbookWithExpensiveKeyboard.printToScreen())
    }

    @Test
    fun checkCustomDesktopCheapKeyboardOutput() {
        val customDesktopWithCheapKeyboard = CustomDesktop(CheapKeyboard())
        val expected = "cheap keyboard"
        assertEquals(expected, customDesktopWithCheapKeyboard.printToScreen())
    }

    @Test
    fun checkCustomDesktopExpensiveKeyboardOutput() {
        val customDesktopWithExpensiveKeyboard = CustomDesktop(ExpensiveKeyboard())
        val expected = "expensive keyboard"
        assertEquals(expected, customDesktopWithExpensiveKeyboard.printToScreen())
    }
}