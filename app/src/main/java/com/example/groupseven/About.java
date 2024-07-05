package com.example.groupseven;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class About extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        TextView t1=findViewById(R.id.name);
        TextView t2=findViewById(R.id.det);

        t1.setTextColor(Color.BLACK);
        t1.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
        t1.setTextSize(20);

        t2.setTextColor(Color.BLACK);
        t2.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
        t2.setTextSize(20);

    }
}
