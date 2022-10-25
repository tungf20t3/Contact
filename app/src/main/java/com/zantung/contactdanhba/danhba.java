package com.zantung.contactdanhba;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class danhba extends AppCompatActivity {
    private static final int REQUEST_CODE_ASK_PERMISSIONS = 1001;
    ListView listViewDB;
    ArrayList<Contact> dsDanhBa;
    ArrayAdapter<Contact> contactArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhba);
        AnhXa();
        showallcontactfromdevice();
    }

    private void showallcontactfromdevice() {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        dsDanhBa.clear();
        while (cursor.moveToNext()){
            //lấy thông tin tên trong danh bạ
            String tenName = ContactsContract.Contacts.DISPLAY_NAME;
            //lấy thông tin sdt trong danh bạ
            String tenPhone = ContactsContract.CommonDataKinds.Phone.NUMBER;
            //lấy vị trí cột trong dữ liệu
            int vitricotName = cursor.getColumnIndex(tenName);
            int vitricotPhone = cursor.getColumnIndex(tenPhone);
            //lấy dữ liệu trong cột ra
            String name = cursor.getString(vitricotName);
            String phone = cursor.getString(vitricotPhone);
            //Đưa vào mảng
            Contact contact = new Contact(name, phone);
            dsDanhBa.add(contact);
            contactArrayAdapter.notifyDataSetChanged();
        }
    }

    private void AnhXa() {
        listViewDB = findViewById(R.id.lvDanhBa);
        dsDanhBa = new ArrayList<>();
        contactArrayAdapter = new ArrayAdapter<>(danhba.this, android.R.layout.simple_list_item_1, dsDanhBa);
        listViewDB.setAdapter(contactArrayAdapter);
    }
}