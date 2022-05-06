package creational.factory

interface Car {
    val brand: String
    enum class Brand {AUDI, MERCEDES}
}

open class Audi : Car {
    override val brand : String = "Audi"

    init {
        println("You rented an Audi")
    }
}

open class Mercedes : Car {
    override var brand : String = "Mercedes"
        get() = field

    init {
        println("You rented a Mercedes")
    }
}