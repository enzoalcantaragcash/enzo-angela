package structural.decorator

class VeggieTopping (private val pizza : Pizza, private val topping : String) : Pizza {
    override fun makePizza(): String {
        return pizza.makePizza() + " " + topping
    }
}