package com.example.bejamerece;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Manual_Loc extends AppCompatActivity {

    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual__loc);

        next = (Button) findViewById(R.id.button4);

        /**
         * change window
         * **/

        next.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(Manual_Loc.this, Personal_Inf.class);
                startActivity(intent);
            }
        });

    }




}