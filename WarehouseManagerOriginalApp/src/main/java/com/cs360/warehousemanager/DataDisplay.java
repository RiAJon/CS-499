package com.cs360.warehousemanager;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class DataDisplay extends AppCompatActivity implements RecyclerViewInterface{

    // create database instance
    Database database = new Database(DataDisplay.this);

    // for sms
    boolean SMSPermission = false;

    // for recycler view
    RecyclerView recyclerView;
    ArrayList<String> name, sku, count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_data_display);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // spinner dropdown menu FIXME: add functionality
        Spinner spinner = (Spinner) findViewById(R.id.warehouse);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.warehouse_array, android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        // for SMS
        int permission = ActivityCompat.checkSelfPermission(DataDisplay.this, android.Manifest.permission.SEND_SMS);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(DataDisplay.this,
                    new String[] {Manifest.permission.SEND_SMS}, 999);

        }
        else {
            // method to send text notification
            sendSMS();
        }

        // for recycler view
        name = new ArrayList<>();
        sku = new ArrayList<>();
        count = new ArrayList<>();

        // create recycler view
        recyclerView = findViewById(R.id.itemRecycler);

        // set RecyclerViewAdapter
        setAdapter();

        // get data from database
        fillArrays();

    }

    // method to send texts based on low stock
    public void sendSMS(){
        Cursor cursor = database.getItems();
        SmsManager manager = SmsManager.getDefault();

        // get shared preference
        SharedPreferences pref = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
        String threshold = pref.getString("threshold","0");
        String phoneNumber = pref.getString("phoneNumber", "+1 555-123-4567");


        // get user defined low stock threshold
        int t = Integer.parseInt(threshold);
        String message = "The following item is low in stock: ";

        if (cursor.moveToFirst()) {
            do {
                // checking the count of each item for low stock
                if (Integer.parseInt(cursor.getString(3)) <= t) {
                    // send text to local port if permission exists
                    manager.sendTextMessage(phoneNumber, null, message + cursor.getString(1), null, null);
                }
                else {
                    break;
                }

            } while (cursor.moveToNext());
        }

    }


    private void fillArrays() {
        Cursor cursor = database.getItems();

        // while there is more data, add it to proper array\
        if (cursor.moveToFirst()) {

            do {
                name.add(cursor.getString(1));
                sku.add(cursor.getString(2));
                count.add(cursor.getString(3));

            } while (cursor.moveToNext());
        }

    }

    private void setAdapter() {
        RecyclerAdapter adapter = new RecyclerAdapter(this, this, name, sku, count);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

    public void onFloatClick(View view) {
        Intent intent = new Intent(this, AddItem.class);
        startActivity(intent);
    }

    public void onPrefClick(View view) {
        Intent intent = new Intent(this, Preferences.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, EditItem.class);

        // pass extras to activity to customize page based on item clicked
        intent.putExtra("name", name.get(position));
        intent.putExtra("sku", sku.get(position));
        intent.putExtra("count", count.get(position));

        startActivity(intent);
    }
}

