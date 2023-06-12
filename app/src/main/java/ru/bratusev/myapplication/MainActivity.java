package ru.bratusev.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ru.bratusev.myapplication.models.Book;
import ru.bratusev.myapplication.models.BookCard;
import ru.bratusev.myapplication.models.BookInsert;

public class MainActivity extends AppCompatActivity{

    public static ProxyPeople people;
    public static boolean isAdmin = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Library library = new Library();

        BookInsert insert = new BookInsert.BookInsertBuilder()
                .setDate("12/06/2023")
                .setDeadline("15/06/2023")
                .setTicketNumber("123-GH")
                .build();

        BookCard card = new BookCard.BookCardBuilder()
                .setName("Золотая рыбка")
                .setBookShelf("Пушкин А.С.")
                .setCount(234)
                .setLibraryDepartment("Художественный")
                .build();

        Book book = new Book(insert, card);

        library.addBook(book);

        people = new ProxyPeople("Ivan", "123-GH", library);

        findViewById(R.id.bt_worker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.authorizeLibrarian();
                isAdmin = true;
                startActivity(new Intent(getApplicationContext(), MainActivity2.class));
            }
        });

        findViewById(R.id.bt_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.authorizeCustomer();
                isAdmin = false;
                startActivity(new Intent(getApplicationContext(), MainActivity2.class));
            }
        });
    }
}