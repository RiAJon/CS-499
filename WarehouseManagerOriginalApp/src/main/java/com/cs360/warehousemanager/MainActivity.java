package com.cs360.warehousemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    // create database instance
    Database database = new Database(MainActivity.this);

    public void onLoginClick(View view) {

        // text edits
        EditText userNameEditText = findViewById(R.id.enter_username_login);
        EditText passwordEditText = findViewById(R.id.enter_password_login);

        String userName_entered = userNameEditText.getText().toString();
        String password_entered = passwordEditText.getText().toString();

        // set intent for click
        Intent intent = new Intent(this, DataDisplay.class);

        // get password
        String password = database.getUserCreds(userName_entered);

        // if user has filled in both text edits
        if (!userName_entered.isEmpty() && !password_entered.isEmpty()) {

            // if the correct username and password have been entered
            if (password_entered.equals(password)) {
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "The username or password you've entered isn't correct. Please try again. ", Toast.LENGTH_LONG).show();
            }
        }
        else {
                Toast.makeText(MainActivity.this, "Please fill out both fields.", Toast.LENGTH_LONG).show();
        }
    }

    public void onRegClick(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    //FIXME: add forgot password functionality

}