package com.example.groupseven;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class Settings extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        TextView deleteAll, darkLight, about,setHead,togLabel;
        DialogThing dialog = new DialogThing();
        ImageButton back=findViewById(R.id.backer);
        ToggleButton toggle=findViewById(R.id.toggle);

        deleteAll = findViewById(R.id.delAll);
        darkLight = findViewById(R.id.darkLight);
        about = findViewById(R.id.about);
        setHead=findViewById(R.id.SettingsHeader);
        togLabel=findViewById(R.id.toggleLabel);

        setHead.setTextColor(Color.BLACK);
        setHead.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        setHead.setTextSize(19);

        togLabel.setTextColor(Color.BLACK);
        togLabel.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        togLabel.setTextSize(18);


        deleteAll.setTextColor(Color.BLACK);
        deleteAll.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        deleteAll.setTextSize(20);

        darkLight.setTextColor(Color.BLACK);
        darkLight.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        darkLight.setTextSize(20);

        about.setTextColor(Color.BLACK);
        about.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        about.setTextSize(20);



        back.setBackgroundColor(Color.TRANSPARENT);

        //back button onclick listener
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateAccount();
                finish();
            }
        });
        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                dialog.show(fragmentManager, "dialog");
            }
        });
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle toggle button state change
                if (toggle.isChecked()) {
                    // Toggle is ON
                    setAppThemeDark();
                } else {
                    // Toggle is OFF
                    setAppThemeLight();
                }
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutPage();
            }
        });
    }
    public void openCreateAccount(){
        Intent intent=new Intent(this,CreateAccount.class);
        startActivity(intent);
    }

    private void setAppThemeDark() {
        // Set background color to black for all pages
        ViewGroup rootView = findViewById(android.R.id.content);
        rootView.setBackgroundColor(Color.BLACK);
    }

    private void setAppThemeLight() {
        // Set background color to white for all pages
        ViewGroup rootView = findViewById(android.R.id.content);
        rootView.setBackgroundColor(Color.WHITE);
    }
    private void openAboutPage(){
        Intent intent1=new Intent(this, About.class);
        startActivity(intent1);
    }
}


