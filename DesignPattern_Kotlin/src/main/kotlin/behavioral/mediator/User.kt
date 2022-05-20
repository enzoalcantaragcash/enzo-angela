package behavioral.mediator

class User (val name: String){


    fun sendMessage (message : String) : String {
        return ChatRoom.showMessage(this, message)

    }
}