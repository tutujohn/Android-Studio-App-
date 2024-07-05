package com.example.groupseven;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

// EnterDetails.java

public class EnterDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_details);
        EditText Pass,Title,Acc,Username;
        String display="Added!";
        Pass = findViewById(R.id.password);
        Username=findViewById(R.id.Username);
        Acc=findViewById(R.id.account);
        Title=findViewById(R.id.Title);
        ImageButton back1 = findViewById(R.id.backer1);

        back1.setBackgroundColor(Color.TRANSPARENT);


        Pass.setTextColor(Color.BLACK);
        Title.setTextColor(Color.BLACK);
        Acc.setTextColor(Color.BLACK);
        Username.setTextColor(Color.BLACK);
        Button save = findViewById(R.id.save);


        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateAccount();
                finish();
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String Tit = Title.getText().toString();
                        String Pas = Pass.getText().toString();
                        String Acco = Acc.getText().toString();
                        String Usernamo = Username.getText().toString();

                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("description", "Title:"+Tit +"\n"+"Password:"+Pas+"\n"+"Account:"+Acco+"\n"+"Password:"+Pas+"\n"+"Username:"+Usernamo);
                        setResult(RESULT_OK, resultIntent);
                        finish();
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(EnterDetails.this, display, duration);
                        toast.show();

                    }
                });

                }


    public void openCreateAccount(){
        Intent intent=new Intent(this,CreateAccount.class);
        startActivity(intent);
    }

    public void returnBack(View view) {
                finish();
            }
        }

