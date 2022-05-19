package structural.bridge

import org.junit.Assert

interface Keyboard {
    fun getUserInput(): String?
}

class CheapKeyboard : Keyboard {
    override fun getUserInput(): String? {
//        return null
        return "cheap keyboard"
    }

}

class ExpensiveKeyboard : Keyboard {
    override fun getUserInput(): String? {
//        return null
        return "expensive keyboard"
    }

}


abstract class Computer protected constructor(keyboard: Keyboard) {
    protected var keyboard: Keyboard

    init {
        this.keyboard = keyboard
    }

    abstract fun printToScreen()
}

class CustomDesktop(keyboard: Keyboard?) : Computer(keyboard!!) {
    override fun printToScreen() {
        println(keyboard.getUserInput())
    }
}

class Macbook(keyboard: Keyboard?) : Computer(keyboard!!) {
    override fun printToScreen() {
        println(keyboard.getUserInput())
    }
}


fun main(args: Array<String>) {
    val macBook: Computer = Macbook(CheapKeyboard())
    macBook.printToScreen()
    val customDesktop: Computer = CustomDesktop(ExpensiveKeyboard())
    customDesktop.printToScreen()

}

