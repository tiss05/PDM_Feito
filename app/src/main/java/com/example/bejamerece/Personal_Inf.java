package com.example.bejamerece;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Personal_Inf extends AppCompatActivity {
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_inf);

        next = (Button) findViewById(R.id.button_confirmar_dados);

        /**
         * change window
         * **/

        next.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(Personal_Inf.this, Picture.class);
                startActivity(intent);
            }
        });


    }




}

