package structural.bridge

import behavioral.mediator.ChatRoom
import java.util.logging.Logger


interface Keyboard {
    fun getUserInput(): String?
}

class CheapKeyboard : Keyboard {
    override fun getUserInput(): String? {
        return "cheap keyboard"
    }

}

class ExpensiveKeyboard : Keyboard {
    override fun getUserInput(): String? {
        return "expensive keyboard"
    }

}


abstract class Computer protected constructor(keyboard: Keyboard) {
    protected var keyboard: Keyboard

    init {
        this.keyboard = keyboard
    }

    abstract fun printToScreen(): String?
}

class CustomDesktop(keyboard: Keyboard?) : Computer(keyboard!!) {
    override fun printToScreen(): String? {
       return keyboard.getUserInput()
    }
}

class Macbook(keyboard: Keyboard?) : Computer(keyboard!!) {
    override fun printToScreen(): String? {
        return keyboard.getUserInput()
    }
}


fun main(args: Array<String>) {
    val logger = Logger.getLogger(ChatRoom::class.java.getName())

    val macBook: Computer = Macbook(CheapKeyboard())
    logger.info(macBook.printToScreen())
    val customDesktop: Computer = CustomDesktop(ExpensiveKeyboard())
    logger.info(customDesktop.printToScreen())
}

