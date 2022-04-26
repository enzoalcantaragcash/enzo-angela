package com.company;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class TestSMSRegisterKeyword {

    @Test
    public void testLowerCase_ExpectTrue() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "register");
        assertTrue(SMSChecker.checkRegisterKeyword(entry));
    }

    @Test
    public void testCapitalizedFirstLetter_ExpectTrue() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Register");
        assertTrue(SMSChecker.checkRegisterKeyword(entry));
    }

    @Test
    public void testUpperCase_ExpectTrue() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "REGISTER");
        assertTrue(SMSChecker.checkRegisterKeyword(entry));
    }

    @Test
    public void testMixedUpperLowerCases_ExpectTrue() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "rEgIsTeR");
        assertTrue(SMSChecker.checkRegisterKeyword(entry));
    }

    @Test
    public void testLeadingTrailingSpaces_ExpectTrue() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", " rEgIsTeR   ");
        assertTrue(SMSChecker.checkRegisterKeyword(entry));
    }

    @Test
    public void testTrailingWord_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "register 1");
        assertFalse(SMSChecker.checkRegisterKeyword(entry));
    }

    @Test
    public void testLeadingWord_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "register register");
        assertFalse(SMSChecker.checkRegisterKeyword(entry));
    }

    @Test
    public void testLeadingTrailingWords_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "register register 1");
        assertFalse(SMSChecker.checkRegisterKeyword(entry));
    }
}
