package com.example.groupseven;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MasterScreenCreation extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_pass);
        EditText editText2,editText;
        TextView textView;
        Button button = findViewById(R.id.con);
        editText2=findViewById(R.id.editTextTextPassword);
        editText=findViewById(R.id.editTextTextPassword2);
        textView=findViewById(R.id.textView3);

        textView.setTextColor(Color.BLACK);
        editText2.setTextColor(Color.BLACK);
        editText.setTextColor(Color.BLACK);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTex = editText.getText().toString();
                String editTex1 = editText2.getText().toString();
                if (!editTex.equals("")) {
                    if (editTex.equals(editTex1)) {
                        // Save the password using SharedPreferences
                        SharedPreferences preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("password", editTex);
                        editor.apply();

                        Toast.makeText(MasterScreenCreation.this, "Successful!", Toast.LENGTH_LONG).show();
                        openCreateAccount();
                    } else {
                        Toast.makeText(MasterScreenCreation.this, "Passwords don't Match", Toast.LENGTH_LONG).show();
                        editTex1 = "";
                        editTex = "";
                    }
                } else {
                    Toast.makeText(MasterScreenCreation.this, "Enter a password, bruh!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void openCreateAccount(){
        Intent intent = new Intent(this, CreateAccount.class );
        startActivity(intent);
    }
}