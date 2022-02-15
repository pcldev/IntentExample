package com.example.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class SampleSharePreActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    CheckBox checkRemember;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_share_pre);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                //Kiem tra viec login , neu checkRemember is check sex luu lai thong tin email , password vao file sharePre
                if(checkRemember.isChecked()){
                    //thuc hien luu lai thong tin
                    //Khoi tao doi tuong cua lop PreManager va goi phuong thuc luu thong tin
                    new PrefManager(SampleSharePreActivity.this).saveLogin(email,password);
                }
                //Goi lai startActivity de thuc hien login thanh cong
                if(email.trim() !=null){
                    Intent intent = new Intent(SampleSharePreActivity.this,ContactManagerActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
    private void getViews(){
        etEmail = findViewById(R.id.editEmailLogin);
        etPassword = findViewById(R.id.etPwdLogin);
        checkRemember = findViewById(R.id.chkRemember);
        btnLogin = findViewById(R.id.btnLoginForm);
    }
    private void saveLoginInfo(String email , String password) {
        //Luu vao file sharePreference
    }
}