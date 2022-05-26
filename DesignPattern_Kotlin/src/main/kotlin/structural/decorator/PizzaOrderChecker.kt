package structural.decorator

class PizzaOrderChecker {

    fun checkPizzaBase(pizzaString : String, expectedPizzaBase: String) : Boolean{

        if(pizzaString.split(":").size != 2) {
            return false
        }

        var pizzaBase = pizzaString.split(":")[0].trim()
        if (expectedPizzaBase.equals(pizzaBase)) {
            return true
        }
        return false
    }

    fun checkPizzaIngredients(pizzaString : String, expectedPizzaIngredients: String) : Boolean {

        if(pizzaString.split(":").size != 2) {
            return false
        }

        var pizzaIngredients = pizzaString.split(":")[1].trim()
        if (expectedPizzaIngredients.equals(pizzaIngredients)) {
            return true
        }
        return false
    }
}