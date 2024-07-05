package com.example.groupseven;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

// CreateAccount.java

public class CreateAccount extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final int REQUEST_CODE_ADD_TODO = 1;
    private TextView tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8,tx9;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.create_account);
            preferences = getSharedPreferences("Passwords", Context.MODE_PRIVATE);
            editor = preferences.edit();
            Drawable drawable = getResources().getDrawable(R.drawable.for_most_important_textviews);
            Spinner spinner = findViewById(R.id.spinner1);



            



            tx1 = findViewById(R.id.i);
            tx2 = findViewById(R.id.ii);
            tx3 = findViewById(R.id.iii);
            tx4 = findViewById(R.id.iv);
            tx5 = findViewById(R.id.v);
            tx6 = findViewById(R.id.vi);
            tx7 = findViewById(R.id.vii);
            tx8 = findViewById(R.id.viii);
            tx9 = findViewById(R.id.ix);
            tx1.setTextSize(20);
            tx1.setTextColor(Color.BLACK);
            tx1.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            tx2.setTextSize(20);
            tx2.setTextColor(Color.BLACK);
            tx2.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            tx3.setTextSize(20);
            tx3.setTextColor(Color.BLACK);
            tx3.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            tx4.setTextSize(20);
            tx4.setTextColor(Color.BLACK);
            tx4.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            tx5.setTextSize(20);
            tx5.setTextColor(Color.BLACK);
            tx5.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            tx6.setTextSize(20);
            tx6.setTextColor(Color.BLACK);
            tx6.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            tx7.setTextSize(20);
            tx7.setTextColor(Color.BLACK);
            tx7.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            tx8.setTextSize(20);
            tx8.setTextColor(Color.BLACK);
            tx8.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            tx9.setTextSize(20);
            tx9.setTextColor(Color.BLACK);
            tx9.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));



            String firstText = preferences.getString("tx1", "");
            String secText = preferences.getString("tx2", "");
            String thiText = preferences.getString("tx3", "");
            String fourText = preferences.getString("tx4", "");
            String fiveText = preferences.getString("tx5", "");
            String sixText = preferences.getString("tx6", "");
            String sevenText = preferences.getString("tx7", "");
            String eightText = preferences.getString("tx8", "");
            String nineText = preferences.getString("tx9", "");

            if (!firstText.equals("")){
                tx1.setText(firstText);
                tx1.setBackground(drawable);
            }
            if (!secText.equals("")){
                tx2.setText(secText);
                tx2.setBackground(drawable);
            }
            if (!thiText.equals("")){
                tx3.setText(thiText);
                tx3.setBackground(drawable);
            }
            if (!fourText.equals("")){
                tx4.setText(fourText);
                tx4.setBackground(drawable);
            }
            if (!fiveText.equals("")){
                tx5.setText(fiveText);
                tx5.setBackground(drawable);
            }
            if (!sixText.equals("")){
                tx6.setText(sixText);
                tx6.setBackground(drawable);
            }
            if (!sevenText.equals("")){
                tx7.setText(sevenText);
                tx7.setBackground(drawable);
            }
            if (!eightText.equals("")){
                tx8.setText(eightText);
                tx8.setBackground(drawable);
            }
            if (!nineText.equals("")){
                tx9.setText(nineText);
                tx9.setBackground(drawable);
            }
//            removed spinner color here

            Button b=findViewById(R.id.cn);
            b.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    openEnterDetActivity();
                }
            });
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.SpinnerItems, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
        }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = parent.getItemAtPosition(position).toString();

        if (position != 0) {
            // Perform actions based on the selected item
            if (selectedItem.equals("Change Master Password")) {
                openEditMasPassActivity();
            } else if (selectedItem.equals("Settings")) {
                openSettings();
            } else if (selectedItem.equals("Exit")) {
                finishAffinity();
            }

            // Reset the spinner selection to the prompt item
            parent.setSelection(0);
        }
    }





    @Override
    public void onNothingSelected(AdapterView<?> parent) {


}




    private boolean doubleBackToExitPressedOnce = false;
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finishAffinity(); //Will close all activities and exit the app
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press again to exit the app", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000); //The delay time in  milliseconds.

    }



    @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == REQUEST_CODE_ADD_TODO && resultCode == RESULT_OK) {
                String desc = data.getStringExtra("description");

                      if (tx1.getText().toString().isEmpty()) {
                        tx1.setText(desc);
                          editor.putString("tx1", desc);
                          editor.apply();
                          tx1.setBackground(getDrawable(R.drawable.for_most_important_textviews));
                    } else if (tx2.getText().toString().isEmpty()) {
                        tx2.setText(desc);
                          editor.putString("tx2", desc);
                          editor.apply();
                          tx2.setBackground(getDrawable(R.drawable.for_most_important_textviews));
                    } else if (tx3.getText().toString().isEmpty()) {
                        tx3.setText(desc);
                          editor.putString("tx3", desc);
                          editor.apply();
                          tx3.setBackground(getDrawable(R.drawable.for_most_important_textviews));
                    } else if (tx4.getText().toString().isEmpty()) {
                          tx4.setText(desc);
                          editor.putString("tx4", desc);
                          editor.apply();
                          tx4.setBackground(getDrawable(R.drawable.for_most_important_textviews));
                      }else if (tx5.getText().toString().isEmpty()) {
                          tx5.setText(desc);
                          editor.putString("tx5", desc);
                          editor.apply();
                          tx5.setBackground(getDrawable(R.drawable.for_most_important_textviews));
                      }else if (tx6.getText().toString().isEmpty()) {
                          tx6.setText(desc);
                          editor.putString("tx6", desc);
                          editor.apply();
                          tx6.setBackground(getDrawable(R.drawable.for_most_important_textviews));
                      }else if (tx7.getText().toString().isEmpty()) {
                          tx7.setText(desc);
                          editor.putString("tx7", desc);
                          editor.apply();
                          tx7.setBackground(getDrawable(R.drawable.for_most_important_textviews));
                      }else if (tx8.getText().toString().isEmpty()) {
                          tx8.setText(desc);
                          editor.putString("tx8", desc);
                          editor.apply();
                          tx8.setBackground(getDrawable(R.drawable.for_most_important_textviews));
                      }else if (tx9.getText().toString().isEmpty()) {
                          tx9.setText(desc);
                          editor.putString("tx9", desc);
                          editor.apply();
                          tx9.setBackground(getDrawable(R.drawable.for_most_important_textviews));
                      }

                      else {
                        CharSequence text = "My Limit has been exceeded!!!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(this, text, duration);
                        toast.show();
                    }
                }}


    public void openEnterDetActivity() {
        Intent intent = new Intent(this, EnterDetails.class);
        startActivityForResult(intent, REQUEST_CODE_ADD_TODO);
    }
    public void openEditMasPassActivity() {
        Intent intent = new Intent(this,EditMasterPassword.class);
        startActivity(intent);
}
    public void openSettings() {
        Intent intent = new Intent(this,Settings.class);
        startActivity(intent);
    }
}
