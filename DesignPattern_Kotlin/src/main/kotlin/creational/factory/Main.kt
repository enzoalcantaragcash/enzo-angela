package creational.factory

fun main () {

    val cadetCarFactory = CarFactory();

    cadetCarFactory.rentACar(Car.Brand.MERCEDES)
    val checkCar = cadetCarFactory.rentACar(Car.Brand.AUDI)

    if (checkCar != null) {
        println(checkCar.brand)
    }


}