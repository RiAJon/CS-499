package com.cs360.warehousemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    // creating database instance with this context
    Database database = new Database(Register.this);

    public void onRegisterClick(View view) {

        // text edits
        EditText userNameEditText = findViewById(R.id.enter_username);
        EditText passwordEditText = findViewById(R.id.enter_password);

        String userName = userNameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // set intent for click
        Intent Regintent = new Intent(this, DataDisplay.class);

        // call method which checks for duplicate username
        boolean duplicate = database.checkName(userName);

        // if user has filled in both text edits
        if (!userName.isEmpty() && !password.isEmpty()) {

            if (duplicate) {
                Toast.makeText(Register.this, "The username you've entered is already taken. Please try another.", Toast.LENGTH_LONG).show();
            } else { // FIXME: should add length verification here

                // add user credentials to database
                database.addUser(userName, password);

                Toast.makeText(Register.this, "You have been registered!.", Toast.LENGTH_LONG).show();
                startActivity(Regintent);
            }
        }
        else {
            Toast.makeText(Register.this, "Please fill out both fields.", Toast.LENGTH_LONG).show();
        }
    }

    public void onLoginClick(View view) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
    }
}




