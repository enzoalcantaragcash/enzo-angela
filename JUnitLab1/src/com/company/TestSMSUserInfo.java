package com.company;

import org.junit.Test;

import java.util.HashMap;

import static com.company.SMSChecker.*;
import static org.junit.Assert.*;

public class TestSMSUserInfo {

    @Test
    public void testValidInput_ExpectTrue() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Marco Valmores, 1973-09-10, Marikina City");
        assertTrue(checkUserInfo(entry));
    }

    @Test
    public void testMissingName_ExpectFalse(){
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "1973-09-10, Marikina City");
        assertFalse(checkUserInfo(entry));
    }

    @Test
    public void testMissingBirthdate_ExpectFalse(){
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Marco Valmores, Marikina City");
        assertFalse(checkUserInfo(entry));
    }

    @Test
    public void testMissingLocation_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Marco, 1973-09-10");
        assertFalse(checkUserInfo(entry));
    }

    @Test
    public void testSingleName_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Marco, 1973-09-10, Marikina City");
        assertFalse(checkUserInfo(entry));
    }

    @Test
    public void testInvalidNameFormat_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "M4rc0 Valmores, 1973-09-10, Marikina City");
        assertFalse(checkUserInfo(entry));
    }

    @Test
    public void testInvalidBirthYear_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Marco Valmores, 2023-09-10, Marikina City");
        assertFalse(checkUserInfo(entry));
    }

    @Test
    public void testInvalidBirthMonth_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Marco Valmores, 1973-14-10, Marikina City");
        assertFalse(checkUserInfo(entry));
    }

    @Test
    public void testInvalidBirthDay_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Marco Valmores, 1973-04-31, Marikina City");
        assertFalse(checkUserInfo(entry));
    }

    @Test
    public void testLeapBirthYear_ExpectTrue() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Marco Valmores, 2004-02-29, Marikina City");
        assertTrue(checkUserInfo(entry));
    }

    @Test
    public void testinvalidDayBirthMonth_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Marco Valmores, 1973-14-42, Marikina City");
        assertFalse(checkUserInfo(entry));
    }

    @Test
    public void testWordInAddressContainsNumbersAndLetters_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Marco Valmores, 1973-14-42, Mar1k1na City");
        assertFalse(checkUserInfo(entry));
    }


}
