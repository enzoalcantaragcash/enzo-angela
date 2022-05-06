package behavioral.mediator

import java.time.LocalDateTime
import java.util.*

class ChatRoom {

    companion object {
        fun showMessage(user: User, message: String) {
            val current = Date()
            println(current.toString() + " [" + user.name + "] : " + message)
        }
    }
}