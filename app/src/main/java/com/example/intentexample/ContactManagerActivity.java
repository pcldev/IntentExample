package com.example.intentexample;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ContactManagerActivity extends AppCompatActivity {

    FloatingActionButton btnAddContact;
    final int INSERT_CODE = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_manager);
        btnAddContact = findViewById(R.id.btnAddContact);
        btnAddContact.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                // thuc hien tao doi tuong intent de mo activity addNewContactActivity
                Intent intent = new Intent(ContactManagerActivity.this,AddNewContactActivity.class);
                // truyen du lieu sang
                intent.putExtra("msg","Mo activity de them moi contact");
                //goi phuong thuc startActivity de mo activity nhan gia tri tra ve
                startActivityForResult(intent,INSERT_CODE);

            }
        });
        getEmailInfo();
    }
    //Khoi ta mot bien ActivityResultLauncher de goi phuong thuc xu ly onActivityResult
//    ActivityResultLauncher<String> addContact = registerForActivityResult()

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //xu ly ket qua tra ve tu activity add new contact

        if(requestCode == INSERT_CODE){
            if(resultCode == RESULT_OK){
                //lay du lieu tu doi tuong intent data va hien thi
                String contactName = data.getStringExtra("name");
                String contactPhoneNumber = data.getStringExtra("phone");
                //hien ket qua
                Toast.makeText(this, "["+contactName+":"+contactPhoneNumber+"]", Toast.LENGTH_SHORT).show();
            }
        }else
            super.onActivityResult(requestCode, resultCode, data);
    }

    private  void getEmailInfo(){
        String email = new PrefManager(ContactManagerActivity.this).getEmail();
        String password = new PrefManager(ContactManagerActivity.this).getPassword();
        Toast.makeText(ContactManagerActivity.this,"Email:"+email+",password:"+password,Toast.LENGTH_SHORT).show();
    }
}