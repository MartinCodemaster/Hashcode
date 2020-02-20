package com.company;

public class Library {

    private Book book;
    private int scanning_days;
    private int number_of_books;
    private int number_of_signup_process_days;
    private int books_shipped_per_day;

    public Library(int number_of_books, int number_of_signup_process_days, int books_shipped_per_day) {
        this.number_of_books = number_of_books;
        this.number_of_signup_process_days = number_of_signup_process_days;
        this.books_shipped_per_day = books_shipped_per_day;
    }

    public int getNumber_of_books() {
        return number_of_books;
    }

    public void setNumber_of_books(int number_of_books) {
        this.number_of_books = number_of_books;
    }

    public int getNumber_of_signup_process_days() {
        return number_of_signup_process_days;
    }

    public void setNumber_of_signup_process_days(int number_of_signup_process_days) {
        this.number_of_signup_process_days = number_of_signup_process_days;
    }

    public int getBooks_shipped_per_day() {
        return books_shipped_per_day;
    }

    public void setBooks_shipped_per_day(int books_shipped_per_day) {
        this.books_shipped_per_day = books_shipped_per_day;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getScanning_days() {
        return scanning_days;
    }

    public void setScanning_days(int scanning_days) {
        this.scanning_days = scanning_days;
    }
}
