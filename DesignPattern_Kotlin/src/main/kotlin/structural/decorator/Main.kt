package structural.decorator

fun main () {


    val baconAndMushroom = VeggieTopping(MeatTopping(BasePizza("Bacon and Mushroom"), "Bacon"), "Mushroom")
    println(baconAndMushroom.makePizza())

}