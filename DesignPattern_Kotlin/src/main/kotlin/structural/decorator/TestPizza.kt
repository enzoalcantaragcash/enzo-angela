package structural.decorator

import org.junit.Test
import org.junit.Assert.*


class TestPizza {

    @Test
    fun checkValidPizzaName_ExpectTrue() {
        val baconAndMushroom = VeggieTopping(MeatTopping(BasePizza("Bacon and Mushroom"), "Bacon"), "Mushroom")
        assertTrue(PizzaOrderChecker().checkPizzaType(baconAndMushroom.makePizza(), "Bacon and Mushroom"))
    }

    @Test
    fun checkInvalidPizzaName_ExpectFalse() {
        val baconAndMushroom = VeggieTopping(MeatTopping(BasePizza("Bacon and Mushroom"), "Bacon"), "Mushroom")
        assertFalse(PizzaOrderChecker().checkPizzaType(baconAndMushroom.makePizza(), "Hawaiian"))
    }

    @Test
    fun checkValidPizzaIngredients_ExpectTrue() {
        val baconAndMushroom = VeggieTopping(MeatTopping(BasePizza("Bacon and Mushroom"), "Bacon"), "Mushroom")
        assertTrue(PizzaOrderChecker().checkPizzaIngredients(baconAndMushroom.makePizza(), "Bacon Mushroom"))
    }

    @Test
    fun checkInvalidPizzaIngredients_ExpectFalse() {
        val baconAndMushroom = VeggieTopping(MeatTopping(BasePizza("Bacon and Mushroom"), "Bacon"), "Mushroom")
        assertFalse(PizzaOrderChecker().checkPizzaIngredients(baconAndMushroom.makePizza(), "Bacon Mushroom Potatoes"))
    }
}