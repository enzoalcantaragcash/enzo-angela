package behavioral.mediator

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class ChatRoom {

    companion object {
        fun showMessage(user: User, message: String) : String {
            val current = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            println(current.toString() + " [" + user.name + "] : " + message)
            return current.toString() + " [" + user.name + "] : " + message
        }
    }
}