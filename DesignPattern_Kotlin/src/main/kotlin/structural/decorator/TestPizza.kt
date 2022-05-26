package structural.decorator

import org.junit.Test
import org.junit.Assert.*


class TestPizza {

    @Test
    fun checkValidPBasePizza_ExpectTrue() {
        val baconAndMushroom = VeggieTopping(MeatTopping(BasePizza(), "Bacon"), "Mushroom")
        assertTrue(PizzaOrderChecker().checkPizzaBase(baconAndMushroom.makePizza(), "Cheese and Tomato Sauce"))
    }

    @Test
    fun checkInvalidPizzaName_ExpectFalse() {
        val baconAndMushroom = VeggieTopping(MeatTopping(BasePizza(), "Bacon"), "Mushroom")
        assertFalse(PizzaOrderChecker().checkPizzaBase(baconAndMushroom.makePizza(), "Hawaiian"))
    }

    @Test
    fun checkValidPizzaIngredients_ExpectTrue() {
        val baconAndMushroom = VeggieTopping(MeatTopping(BasePizza(), "Bacon"), "Mushroom")
        assertTrue(PizzaOrderChecker().checkPizzaIngredients(baconAndMushroom.makePizza(), "Bacon Mushroom"))
    }

    @Test
    fun checkInvalidPizzaIngredients_ExpectFalse() {
        val baconAndMushroom = VeggieTopping(MeatTopping(BasePizza(), "Bacon"), "Mushroom")
        assertFalse(PizzaOrderChecker().checkPizzaIngredients(baconAndMushroom.makePizza(), "Bacon Mushroom Potatoes"))
    }
}