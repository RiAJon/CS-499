package com.cs360.warehousemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddItem extends AppCompatActivity { //FIXME: add photo functionality

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_item);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    // item quantity
    int quantity = 0;

    // creating database instance with this context
    Database database = new Database(AddItem.this);

    // on decrease button click
    public void onDecrease(View view){
        quantity--;
        String quantDisplay = Integer.toString(quantity);

        TextView quantView = findViewById(R.id.quantView);
        quantView.setText(quantDisplay);
    }

    // on increase button click
    public void onIncrease(View view){
        quantity++;
        String quantDisplay = Integer.toString(quantity);

        TextView quantView = findViewById(R.id.quantView);
        quantView.setText(quantDisplay);
    }

    // add button on click
    public void onAdd(View view){

        // text edits
        EditText itemNameEditText = findViewById(R.id.enter_name);
        EditText itemSkuEditText = findViewById(R.id.enter_sku);

        String itemName = itemNameEditText.getText().toString();
        String itemSku = itemSkuEditText.getText().toString();

        // add item to database
        String quantDisplay = Integer.toString(quantity);
        database.addItem(itemName, itemSku, quantDisplay);

        Toast.makeText(AddItem.this, "Item Added!", Toast.LENGTH_LONG).show();

        // go back to data display page
        Intent addIntent = new Intent(this, DataDisplay.class);
        startActivity(addIntent);
    }





}