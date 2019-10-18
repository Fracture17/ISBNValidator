package com.virtualpairprogrammers.isbntools;

public class StockManager {
    private ExternalISBNDataService webService;
    private ExternalISBNDataService databaseService;

    public void setDatabaseService(ExternalISBNDataService databaseService) {
        this.databaseService = databaseService;
    }

    public void setWebService(ExternalISBNDataService webService) {
        this.webService = webService;
    }

    public String getLocatorCode(String isbn) {
        Book book = databaseService.lookup(isbn);
        if(book == null) {
            book = webService.lookup(isbn);
        }

        return makeLocatorCode(book);
    }

    private String makeLocatorCode(Book book) {
        String isbn = book.getIsbn();
        String title = book.getTitle();
        String author = book.getAuthor();

        StringBuilder locator = new StringBuilder();
        locator.append(isbn.substring(isbn.length() - 4));
        locator.append(author.substring(0, 1));
        locator.append(title.split(" ").length);
        return locator.toString();
    }
}
