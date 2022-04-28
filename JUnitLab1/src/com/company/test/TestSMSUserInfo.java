package com.company.test;

import com.company.SMSChecker;
import org.junit.Test;

import java.util.HashMap;

import static com.company.SMSChecker.*;
import static org.junit.Assert.*;

public class TestSMSUserInfo {

    @Test
    public void testNull_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "");
        assertFalse(checkUserInfo(entry));
    }

    @Test
    public void testEmpty_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", " ");
        assertFalse(checkUserInfo(entry));
    }

    @Test
    public void testValidInput_ExpectTrue() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Juan Dela Cruz, 1973-09-10, Marikina City");
        assertTrue(checkUserInfo(entry));
    }

    @Test
    public void testThreeInfoWithLeadingTrailingSpaces_ExpectTrue() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "   Juan Dela Cruz  , 1973-09-10  , Marikina City  ");
        assertTrue(SMSChecker.checkUserInfo(entry));
    }

    @Test
    public void testImproperDelimiterForText_ExpectTrue() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Juan Dela Cruz/ 1973-09-10/ Marikina City");
        assertFalse(SMSChecker.checkUserInfo(entry));

        HashMap<String, String> entry2 = new HashMap<>();
        entry2.put("Message", "Juan Dela Cruz. 1973-09-10. Marikina City");
        assertFalse(SMSChecker.checkUserInfo(entry2));
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
        entry.put("Message", "Juan Dela Cruz, Marikina City");
        assertFalse(checkUserInfo(entry));
    }

    @Test
    public void testFourInfo_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Juan dela Cruz, 2000-01-01, Sta. Rosa, Laguna");
        assertFalse(SMSChecker.checkUserInfo(entry));
    }

    @Test
    public void testMissingLocation_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Juan Dela Cruz, 1973-09-10");
        assertFalse(checkUserInfo(entry));
    }

    @Test
    public void testSingleName_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Juan, 1973-09-10, Marikina City");
        assertFalse(checkUserInfo(entry));
    }

    @Test
    public void testNameHasNumbers_ExpectFalse() {
        HashMap<String, String> entryOne = new HashMap<>();
        entryOne.put("Message", "Juan dela Cruz123, 2000-01-01, Pasig City");
        assertFalse(SMSChecker.checkUserInfo(entryOne));

        HashMap<String, String> entryTwo = new HashMap<>();
        entryTwo.put("Message", "Juan123 dela Cruz, 2000-01-01, Pasig City");
        assertFalse(SMSChecker.checkUserInfo(entryTwo));
    }

    @Test
    public void testInvalidBirthYear_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Juan Dela Cruz, 2023-09-10, Marikina City");
        assertFalse(checkUserInfo(entry));
    }

    @Test
    public void testInvalidBirthMonth_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Juan Dela Cruz, 1973-14-10, Marikina City");
        assertFalse(checkUserInfo(entry));
    }

    @Test
    public void testInvalidBirthDay_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Juan Dela Cruz, 1973-04-31, Marikina City");
        assertFalse(checkUserInfo(entry));
    }

    @Test
    public void testLeapBirthYear_ExpectTrue() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Juan Dela Cruz, 2004-02-29, Marikina City");
        assertTrue(checkUserInfo(entry));
    }

    @Test
    public void testinvalidDayBirthMonth_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Juan Dela Cruz, 1973-14-42, Marikina City");
        assertFalse(checkUserInfo(entry));
    }

    @Test
    public void testDateWrongFormat_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Juan dela Cruz, 01-01-2000, Pasig City");
        assertFalse(SMSChecker.checkUserInfo(entry));
    }

    @Test
    public void testCurrentDate_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Juan dela Cruz, 2022-04-27, Pasig City");
        assertFalse(SMSChecker.checkUserInfo(entry));
    }

    @Test
    public void testFutureDate_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Juan dela Cruz, 2022-05-01, Pasig City");
        assertFalse(SMSChecker.checkUserInfo(entry));
    }

    @Test
    public void testNotDate_ExpectFalse() {
        HashMap<String, String> entryOne = new HashMap<>();
        entryOne.put("Message", "Juan dela Cruz, 2000-01-01-10, Pasig City");
        assertFalse(SMSChecker.checkUserInfo(entryOne));

        HashMap<String, String> entryTwo = new HashMap<>();
        entryTwo.put("Message", "Juan dela Cruz, 2000-0110-01, Pasig City");
        assertFalse(SMSChecker.checkUserInfo(entryTwo));
    }

    @Test
    public void testIncompleteDate_ExpectFalse() {
        HashMap<String, String> entryOne = new HashMap<>();
        entryOne.put("Message", "Juan dela Cruz, 1, Pasig City");
        assertFalse(SMSChecker.checkUserInfo(entryOne));

        HashMap<String, String> entryTwo = new HashMap<>();
        entryTwo.put("Message", "Juan dela Cruz, 2000-01, Pasig City");
        assertFalse(SMSChecker.checkUserInfo(entryTwo));
    }

    @Test
    public void testDateHasLetters_ExpectFalse() {
        HashMap<String, String> entryOne = new HashMap<>();
        entryOne.put("Message", "Juan dela Cruz, 2000-a1-01, Pasig City");
        assertFalse(SMSChecker.checkUserInfo(entryOne));

        HashMap<String, String> entryTwo = new HashMap<>();
        entryTwo.put("Message", "Juan dela Cruz, Jan 1 2000, Pasig City");
        assertFalse(SMSChecker.checkUserInfo(entryTwo));
    }

    @Test
    public void testDateWithOtherDelimiter_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Juan dela Cruz, 2000/01/01, Pasig City");
        assertFalse(SMSChecker.checkUserInfo(entry));
    }

    @Test
    public void testWordInAddressContainsNumbersAndLetters_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Juan Dela Cruz, 1973-14-42, Mar1k1na City");
        assertFalse(checkUserInfo(entry));
    }

    @Test
    public void testNotAddress_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Juan dela Cruz, 2000-01-01, M");
        assertFalse(SMSChecker.checkUserInfo(entry));
    }

    @Test
    public void testInvalidAddress_ExpectFalse() {
        HashMap<String, String> entry = new HashMap<>();
        entry.put("Message", "Juan dela Cruz, 2000-01-01, 82 FC Tuazon");
        assertFalse(SMSChecker.checkUserInfo(entry));
    }
}
