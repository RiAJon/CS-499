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

public class EditItem extends AppCompatActivity {

    int quantity;
    String name;

    // create database instance
    Database database = new Database(EditItem.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_item);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // extra values passed by intent
        name = getIntent().getStringExtra("name");
        String sku = getIntent().getStringExtra("sku");
        String count = getIntent().getStringExtra("count");

        // set values passed by intent to display
        TextView title = findViewById(R.id.item);
        title.setText(name);

        EditText editName = findViewById(R.id.enter_name);
        editName.setText(name);

        EditText editSku = findViewById(R.id.enter_sku);
        editSku.setText(sku);

        TextView editCount = findViewById(R.id.enter_count);
        editCount.setText(count);

        countToQuantity(count);
    }

    // converts count string to int to be used by methods below
    public void countToQuantity(String count) {
        // item quantity
        quantity = Integer.parseInt(count);
    }


    // on decrease button click
    public void onEditDecrease(View view){
        quantity--;
        String quantDisplay = Integer.toString(quantity);

        TextView quantView = findViewById(R.id.enter_count);
        quantView.setText(quantDisplay);
    }

    // on increase button click
    public void onEditIncrease(View view){
        quantity++;
        String quantDisplay = Integer.toString(quantity);

        TextView quantView = findViewById(R.id.enter_count);
        quantView.setText(quantDisplay);
    }

    public void onUpdate(View view){

        // text edits
        EditText nameEdit = findViewById(R.id.enter_name);
        EditText skuEdit = findViewById(R.id.enter_sku);

        String nameNew = nameEdit.getText().toString();
        String skuNew = skuEdit.getText().toString();
        String countNew = Integer.toString(quantity);

        boolean updated = database.updateItem(name, nameNew, skuNew, countNew);

        if (updated){
            Toast.makeText(EditItem.this, "Item Updated!", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, DataDisplay.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(EditItem.this, "The item could not be updated.", Toast.LENGTH_LONG).show();
        }

    }

    public void onDelete(View view) {

        boolean deleted = database.deleteItem(name);

        if (deleted){
            Toast.makeText(EditItem.this, "Item Deleted!", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, DataDisplay.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(EditItem.this, "The item could not be deleted.", Toast.LENGTH_LONG).show();
        }
    }
}