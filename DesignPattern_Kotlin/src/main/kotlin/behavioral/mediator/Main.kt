package behavioral.mediator

fun main () {

    var robert = User("Robert")
    var john = User("John")
    robert.sendMessage("Hi John!")
    john.sendMessage("Hi Robert!")
}