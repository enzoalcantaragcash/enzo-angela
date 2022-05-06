package creational.factory

class CarFactory {

    fun rentACar(brand : Car.Brand) : Car? {
        when (brand) {
            Car.Brand.AUDI -> return Audi()
            Car.Brand.MERCEDES -> return Mercedes()
            else -> return null
        }
    }
}