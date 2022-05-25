package creational.factory

import behavioral.mediator.ChatRoom
import java.util.logging.Logger

interface Car {
    val brand: String
    enum class Brand {AUDI, MERCEDES}
}



open class Audi : Car {
    override val brand : String = "Audi"
    val logger = Logger.getLogger(Audi::class.java.getName())

    init {
        logger.info("You rented an Audi")
    }
}

open class Mercedes : Car {
    override var brand : String = "Mercedes"
    val logger = Logger.getLogger(Mercedes::class.java.getName())


    init {
        logger.info("You rented a Mercedes")
    }
}