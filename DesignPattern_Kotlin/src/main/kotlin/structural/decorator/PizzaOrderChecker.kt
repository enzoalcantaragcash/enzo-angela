package structural.decorator

class PizzaOrderChecker {

    fun checkPizzaType(pizzaString : String, expectedPizzaName: String) : Boolean{

        if(pizzaString.split(":").size != 2) {
            return false
        }

        var pizzaName = pizzaString.split(":")[0].trim()
        if (expectedPizzaName.equals(pizzaName)) {
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