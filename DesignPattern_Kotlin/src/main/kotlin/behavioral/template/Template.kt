package behavioral.template

abstract class Game {
    abstract fun initialize(): String
    abstract fun startPlay(): String
    abstract fun endPlay(): String
    fun play() {

        //initialize game
        println(initialize())

        //start the game
        println(startPlay())

        //end the game
        println(endPlay())
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