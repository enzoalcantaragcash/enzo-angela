package behavioral.template

import behavioral.mediator.ChatRoom
import java.util.logging.Logger



abstract class Game {
    private val logger = Logger.getLogger(ChatRoom::class.java.getName())

    abstract fun initialize(): String
    abstract fun startPlay(): String
    abstract fun endPlay(): String
    fun play() {

        //initialize game
        logger.info(initialize())

        //start the game
        logger.info(startPlay())

        //end the game
        logger.info(endPlay())
    }
}

class Football : Game() {
    override fun initialize(): String {
        return "Football game initialized! Start Playing!"
    }

    override fun startPlay(): String {
        return "Football game started. Enjoy!"
    }

    override fun endPlay(): String {
        return "Football game finished"
    }
}

class Cricket : Game() {
    override fun initialize(): String {
        return "Cricket game initialized! Start Playing!"
    }

    override fun startPlay(): String {
        return "Cricket game started. Enjoy!"
    }

    override fun endPlay(): String {
        return "Cricket game finished"
    }
}

fun main(args: Array<String>) {
    var game: Game = Cricket()
    game.play()
    game = Football()
    game.play()
}