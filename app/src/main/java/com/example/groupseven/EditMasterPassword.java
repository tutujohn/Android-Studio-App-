package com.example.groupseven;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class EditMasterPassword extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_maspass);
        EditText changer=findViewById(R.id.reseter);
        Button save=findViewById(R.id.theSave);
        ImageButton back2 = findViewById(R.id.backer2);
        back2.setBackgroundColor(Color.TRANSPARENT);




        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateAccount();
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!changer.getText().toString().equals("")) {
                    String newPassword = changer.getText().toString();

                    // Retrieve the password
                    SharedPreferences preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("password", newPassword);
                    editor.apply();
                    openCreateAccount();
                    finish();
                } }});

    }
    public void openCreateAccount(){
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }}