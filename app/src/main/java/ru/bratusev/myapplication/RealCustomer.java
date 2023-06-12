package ru.bratusev.myapplication;

import ru.bratusev.myapplication.models.Book;

public class RealCustomer implements Customer{
    private String name;
    private String ticketNumber;
    private Book book;

    public RealCustomer(String name, String ticketNumber) {
        this.name = name;
        this.ticketNumber = ticketNumber;
        book = null;
    }

    public String getName() {
        return name;
    }

    @Override
    public void viewBooks() {
        System.out.println("Пользователь смотрите книги");
    }

    @Override
    public void getBookFromLibrary(String author, String name) {}

    @Override
    public void getBookFromLibrary(Book book) {
        if (this.book == null) this.book = book;
    }

    @Override
    public Book returnBook() {
        Book tmp = book;
        book = null;
        return tmp;
    }

    @Override
    public void payFine() {
        System.out.println("Оплатить штраф");
    }
}
