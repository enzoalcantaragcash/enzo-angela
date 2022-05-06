package structural.decorator

class BasePizza (private val pizzaType: String) : Pizza {
    override fun makePizza(): String {
        return "$pizzaType : "
    }

}