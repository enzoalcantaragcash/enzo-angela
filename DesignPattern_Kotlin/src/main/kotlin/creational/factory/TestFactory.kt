package creational.factory

import org.junit.Test
import org.junit.Assert.*

class TestFactory {

    @Test
    fun checkCarRentedIfMercedes_ExpectEqual() {
        val rentMercedes = CarFactory().rentACar(Car.Brand.MERCEDES)
        assertEquals("Mercedes", rentMercedes!!.brand)
    }

    @Test
    fun checkCarRentedIfAudi_ExpectEqual() {

        val rentAudi = CarFactory().rentACar(Car.Brand.AUDI)
        assertEquals("Audi", rentAudi!!.brand)
    }



}