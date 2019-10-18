package com.virtualpairprogrammers.isbntools;

public class ValidatorISBN {
    private static final int SHORT_ISBN_LENGTH = 10;
    private static final int LONG_ISBN_LENGTH = 13;
    private static final int SHORT_ISBN_CHECKSUM = 11;
    private static final int LONG_ISBN_CHECKSUM = 10;

    public boolean checkISBN(String isbn) {
        if(isbn.length() == LONG_ISBN_LENGTH) {
            checkLongISBNFormat(isbn);
            int result = computeLongISBNSum(isbn);
            return result % LONG_ISBN_CHECKSUM == 0;
        }
        else {
            checkShortISBNFormat(isbn);
            int result = computeShortISBNSum(isbn);
            return result % SHORT_ISBN_CHECKSUM == 0;
        }
    }

    private int computeShortISBNSum(String isbn) {
        int result = 0;
        for(int i = 0; i < SHORT_ISBN_LENGTH; i++) {
            if(isbn.charAt(i) == 'X') {
                result += 10 * (10 - i);
            }
            else {
                result += (isbn.charAt(i) - '0') * (10 - i);
            }
        }
        return result;
    }

    private int computeLongISBNSum(String isbn) {
        int result = 0;
        for(int i = 0; i < LONG_ISBN_LENGTH; i++) {
            if(i % 2 == 0) {
                result += (isbn.charAt(i) - '0');
            }
            else {
                result += (isbn.charAt(i) - '0') * 3;
            }
        }
        return result;
    }

    private void checkShortISBNFormat(String isbn) {
        if(isbn.matches("[0-9]+X?") == false) {
            throw new NumberFormatException();
        }

        if(isbn.length() != SHORT_ISBN_LENGTH) {
            throw new NumberFormatException();
        }
    }

    private void checkLongISBNFormat(String isbn) {
        if(isbn.matches("[0-9]+") == false) {
            throw new NumberFormatException();
        }

        if(isbn.length() != LONG_ISBN_LENGTH) {
            throw new NumberFormatException();
        }
    }
}
