package com.zantung.contactdanhba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CONTACTS_ASK_PERMISSIONS = 1001;
    private static final int REQUEST_SMS_ASK_PERMISSIONS = 1002;
    Button btn_DanhBa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_DanhBa = findViewById(R.id.btn_docDanhBa);
        addEvent();
    }

    private void addEvent() {
        btn_DanhBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xulymomanhinhdanhba();
            }
        });

    }

    private void xulymomanhinhdanhba() {
        Intent intent = new Intent(MainActivity.this, danhba.class);
        intent.setClassName("com.zantung.contactdanhba", "com.zantung.contactdanhba.DanhBa");
        startActivity(intent);
    }
}