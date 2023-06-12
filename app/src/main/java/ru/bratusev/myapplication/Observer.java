package ru.bratusev.myapplication;

import java.util.ArrayList;

import ru.bratusev.myapplication.models.Book;

public interface Observer {
    void update(ArrayList<Book> books);
}
