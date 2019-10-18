package com.virtualpairprogrammers.isbntools;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateISBNTest {

    @Test
    public void checkAValid10DigitISBN() {
        ValidatorISBN validator = new ValidatorISBN();

        boolean result = validator.checkISBN("0140449116");
        assertTrue(result);

        result = validator.checkISBN("0140177396");
        assertTrue(result);
    }

    @Test
    public void checkAnInvalid10DigitISBN() {
        ValidatorISBN validator = new ValidatorISBN();
        boolean result = validator.checkISBN("0140449117");
        assertFalse(result);
    }

    @Test(expected = NumberFormatException.class)
    public void nineDigitISBNsAreNotAllowed() {
        ValidatorISBN validator = new ValidatorISBN();
        validator.checkISBN("123456789");
    }

    @Test(expected = NumberFormatException.class)
    public void ISBNHasToBeAllNumbers() {
        ValidatorISBN validator = new ValidatorISBN();
        validator.checkISBN("helloworld");
    }

    @Test
    public void tenDigitISBNNumbersEndingInAnXAreValid() {
        ValidatorISBN validator = new ValidatorISBN();
        boolean result = validator.checkISBN("012000030X");
        assertTrue(result);
    }

    @Test
    public void checkAValid13DigitISBN() {
        ValidatorISBN validator = new ValidatorISBN();

        boolean result = validator.checkISBN("9780545791427");
        assertTrue(result);
    }

    @Test
    public void checkAnInvalid13DigitISBN() {
        ValidatorISBN validator = new ValidatorISBN();
        boolean result = validator.checkISBN("9780545791428");
        assertFalse(result);
    }
}
