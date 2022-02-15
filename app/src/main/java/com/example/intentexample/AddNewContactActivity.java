package com.example.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNewContactActivity extends AppCompatActivity {

    EditText etWebsite , nameId , phoneNumberId ;
    Button btnOpenWebsite , btnSave , btnClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact2);
        // lay ra intent nhan duoc tu contactManagerActivity
        getViews();
        Intent receiveIntent = getIntent();
        String message = receiveIntent.getStringExtra("msg"); // truyen vao doi so can tim.
        Toast.makeText(AddNewContactActivity.this, "msg ["+ message + "]", Toast.LENGTH_SHORT).show();
        btnOpenWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //lay ra dia chi cua website can mo
                String url = etWebsite.getText().toString();
                if (!url.startsWith("http://") && !url.startsWith("https://"))
                    url = "http://" + url;
                //ep kieu ve doi tuong URI
                Uri webpage = Uri.parse(url);
                //tao doi tuong Intent voi Intent.ACTION_VIEW
                Intent intentOpen = new Intent(Intent.ACTION_VIEW,webpage);
                startActivity(intentOpen);
//                if(intentOpen.resolveActivity(getPackageManager())!=null){
//                    //startActivity de mo website
//
//                }else{
//                    Toast.makeText(AddNewContactActivity.this,"Khong the goi cac dich vu",Toast.LENGTH_SHORT).show();
//                    Log.d("Intent khong tuong minh ","Khong the goi cac dich vu");
//                }
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent();
                intent.putExtra("name",nameId.getText().toString());
                intent.putExtra("phone",phoneNumberId.getText().toString());
                //goi phuong thuc de gui intent ket qua ve activity contactmanager
                setResult(RESULT_OK,intent);
                //dong activity
                finish();
            }
        });
    }
    private void getViews(){
        etWebsite = findViewById(R.id.etWebsite);
        btnOpenWebsite = findViewById(R.id.btnOpenWebsite);
        nameId = findViewById(R.id.nameId);
        phoneNumberId = findViewById(R.id.phoneNumberId);
        btnSave = findViewById(R.id.btnSave);
        btnClose = findViewById(R.id.btnClose);
    }
}