package com.example.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class DemoSQLiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_sqlite);

    }
    private void initDatabase(){
        String sql="\"DROP TABLE IF EXISTS BOOKS;\\n"\n" +
                "+ \"CREATE TABLE BOOKS(BookID integer PRIMARY KEY, BookName text, " + " Price Float);\\n"\n";

        //Thuc hien mo file database
        SQLiteDatabase db = openOrCreateDatabase("book.db",MODE_PRIVATE,null);
        //thuc thi cau lenh truy van
        for(String s: sql.split("\n")){
            db.execSQL(s);
        }
        //dong csdl
        db.close();
    }

}