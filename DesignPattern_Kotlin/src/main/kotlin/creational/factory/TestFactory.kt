package creational.factory

import org.junit.Test
import org.junit.Assert.*

class TestFactory {

    @Test
    fun checkCarRented() {
        val rentMercedes = CarFactory().rentACar(Car.Brand.MERCEDES)
        val expectedMercedes = "Mercedes"
        assertEquals(expectedMercedes, rentMercedes!!.brand)

        val rentAudi = CarFactory().rentACar(Car.Brand.AUDI)
        val expectedAudi = "Audi"
        assertEquals(expectedAudi, rentAudi!!.brand)
    }



}