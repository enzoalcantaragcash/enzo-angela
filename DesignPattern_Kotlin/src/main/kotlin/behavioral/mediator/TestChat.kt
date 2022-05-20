package behavioral.mediator

import org.junit.Test
import org.junit.Assert.*

class TestChat {

    var robert = User("Robert")
    var john = User("John")

    @Test
    fun checkDateBasedOnFormat_ExpectTrue() {
        assertTrue(ChatChecker().checkDate(robert.sendMessage("Hello"), "yyyy-MM-dd HH:mm:ss"))
    }

    @Test
    fun checkMessageContent_ExpectTrue() {
        assertTrue(ChatChecker().checkMessageContent(robert.sendMessage("Hello"), "Hello"))
    }

    @Test
    fun checkUser_ExpectTrue() {
        assertTrue(ChatChecker().checkUser(robert.sendMessage("Hello"), "Robert"))
    }

    @Test
    fun checkDateWithInvalidFormat_ExpectFalse() {
        assertFalse(ChatChecker().checkDate(robert.sendMessage("Hello"), "MM-dd-yyy"))
    }

    @Test
    fun checkMessageContentIfNotSame_ExpectFalse() {
        assertFalse(ChatChecker().checkMessageContent(robert.sendMessage("Hello"), "Hi"))
    }

    @Test
    fun checkUserDifferent_ExpectFalse() {
        assertFalse(ChatChecker().checkUser(robert.sendMessage("Hello"), "Bob"))
    }
}