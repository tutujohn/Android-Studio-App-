package com.example.groupseven;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Typeface;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    
    //TODO:ADD MASTER PASSWORD VERIFICATION
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t1,t2;
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView4);

        t1.setTextColor(Color.BLACK);
        t1.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
        t1.setTextSize(19);

        t2.setTextColor(Color.BLACK);
        t2.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        t2.setTextSize(17);


        Button createAccount = findViewById(R.id.Continue);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get an instance of SharedPreferences
                SharedPreferences preferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

                // Retrieve the password
                String savedPassword = preferences.getString("password", "");
                if (!savedPassword.equals("")) {
                    openLoginActivity();
                } else {
                    openCreateActivity();
                }
            }
        });
    }

    public void openCreateActivity(){
        Intent intent = new Intent(this, MasterScreenCreation.class );
        startActivity(intent);
    }
    public void openLoginActivity(){
        Intent intent1 =new Intent(this, LoginCreate.class);
        startActivity(intent1);
    }
}
