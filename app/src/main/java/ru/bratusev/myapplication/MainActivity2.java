package ru.bratusev.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import ru.bratusev.myapplication.models.Book;

public class MainActivity2 extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView listView = (ListView) findViewById(R.id.list);

        ArrayList<String> strings_req = new ArrayList<>();

        if(MainActivity.isAdmin){
            strings_req.add("Пушкин А.С.\nЗолотая рыбка");
            strings_req.add("заявка 2");
            strings_req.add("заявка 3");
            strings_req.add("заявка 4");
            strings_req.add("заявка 5");
        }else{
            ((TextView)findViewById(R.id.title)).setText("Отделы");
            strings_req.add("отдел 1");
            strings_req.add("отдел 2");
            strings_req.add("отдел 3");
            strings_req.add("отдел 4");
            strings_req.add("отдел 5");
        }

        listView.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, strings_req));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(MainActivity.isAdmin){
                    Book book = MainActivity.people.getBookForCustomer(strings_req.get(position).split("\n")[0], strings_req.get(position).split("\n")[1]);

                    Log.d("MyLog", book.toString());
                }else{
                    startActivity(new Intent(getApplicationContext(), MainActivity3.class));
                }
            }
        });
    }
}