package behavioral.mediator

import org.apache.commons.lang3.StringUtils
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class ChatChecker {

    fun checkDate(message:String, pattern:String) :Boolean {

        var splitMessage = message.split("[")
        var dateString = splitMessage[0].trim()
        try {
            LocalDate.parse(dateString, DateTimeFormatter.ofPattern(pattern))
        } catch (e: DateTimeParseException) {
            return false
        }
        return true
    }

    fun checkMessageContent(message:String, expectedMessage:String) : Boolean {
        var splitMessage = message.split(" : ")
        var messageContentString = splitMessage[1].trim()
        if(messageContentString.equals(expectedMessage)) {
            return true
        }
        return false
    }

    fun checkUser(message: String, expectedUser:String) : Boolean{
        var user = StringUtils.substringBetween(message, "[", "]")
        if(user.equals(expectedUser)) {
            return true
        }
        return false
    }

}