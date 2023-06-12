package ru.bratusev.myapplication;

import ru.bratusev.myapplication.models.Book;

public interface Librarian {
    void viewBooks();

    Book getBookForCustomer(String author, String name);

    void writeInCard(Book book);

    void returnBook(Book book);

    void writeOff(Book book);

    void issueFine();
}
