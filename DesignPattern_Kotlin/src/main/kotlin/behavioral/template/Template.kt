package behavioral.template

abstract class Game {
    abstract fun initialize()
    abstract fun startPlay()
    abstract fun endPlay()
    fun play() {

        //initialize game
        initialize()

        //start the game
        startPlay()

        //end the game
        endPlay()
    }
}

class Football : Game() {
    override fun initialize() {
        println("Football game initialized! Start Playing!")
    }

    override fun startPlay() {
        println("Football game started. Enjoy!")
    }

    override fun endPlay() {
        println("Football game finished")
    }
}

class Cricket : Game() {
    override fun initialize() {
        println("Cricket game initialized! Start Playing!")
    }

    override fun startPlay() {
        println("Cricket game started. Enjoy!")
    }

    override fun endPlay() {
        println("Cricket game finished")
    }
}

fun main(args: Array<String>t) {
    var game: Game = Cricket()
    game.play()
    game = Football()
    game.play()
}