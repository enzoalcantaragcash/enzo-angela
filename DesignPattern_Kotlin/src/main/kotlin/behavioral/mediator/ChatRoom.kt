package behavioral.mediator

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.logging.Logger

class ChatRoom {


    companion object {
        fun showMessage(user: User, message: String) : String {

            val logger = Logger.getLogger(ChatRoom::class.java.getName())
            val current = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            logger.info(current.toString() + " [" + user.name + "] : " + message)
            return current.toString() + " [" + user.name + "] : " + message
        }
    }
}