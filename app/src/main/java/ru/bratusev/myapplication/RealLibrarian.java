package ru.bratusev.myapplication;

import ru.bratusev.myapplication.models.Book;
import ru.bratusev.myapplication.models.BookInsert;

public class RealLibrarian implements Librarian {
    private String name;
    private Library library;

    public RealLibrarian(String name, Library library) {
        this.name = name;
        this.library = library;
    }

    public String getName() {
        return name;
    }

    @Override
    public void viewBooks() {
        System.out.println(library.getBooks());
    }

    @Override
    public Book getBookForCustomer(String author, String name) {
        Book book = library.findBook(author, name);
        library.removeBook(book);
        return book;
    }

    @Override
    public void writeInCard(Book book) {
        book.setBookInsert(new BookInsert.BookInsertBuilder()
                .setDate("01/01/2023")
                .setDeadline("01/02/2023")
                .setTicketNumber("123-GH")
                .build());
    }

    @Override
    public void returnBook(Book book) {
        library.addBook(book);
    }

    @Override
    public void writeOff(Book book) {
        System.out.println("Списать книгу");
    }

    @Override
    public void issueFine() {
        System.out.println("Выписать штраф");
    }
}
