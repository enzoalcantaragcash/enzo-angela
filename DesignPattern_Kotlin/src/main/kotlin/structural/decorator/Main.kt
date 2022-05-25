package structural.decorator

import java.util.logging.Logger

fun main() {

        val logger = Logger.getLogger(BasePizza::class.java.getName())
        val baconAndMushroom = VeggieTopping(MeatTopping(BasePizza("Bacon and Mushroom"), "Bacon"), "Mushroom")
        logger.info(baconAndMushroom.makePizza())

    }
