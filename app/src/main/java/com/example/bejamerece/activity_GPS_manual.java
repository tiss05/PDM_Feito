package com.example.bejamerece;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_GPS_manual extends AppCompatActivity {

    private Button next;
    private EditText localidade;
    private EditText freguesia;
    private EditText rua;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual__loc);

        localidade = (EditText) findViewById(R.id.editText_localidade);
        freguesia = (EditText) findViewById(R.id.editText_freguesia);
        rua = (EditText) findViewById(R.id.editText_rua);
        next = (Button) findViewById(R.id.button4);


        /**
         * change window
         * **/
        next.setOnClickListener(new View.OnClickListener() {

         public void onClick(View view) {
             if (!freguesia.getText().toString().isEmpty() || !rua.getText().toString().isEmpty() || !localidade.getText().toString().isEmpty()) {
                 Intent intent = new Intent(activity_GPS_manual.this, Personal_Inf.class);
                 startActivity(intent);

             } else {
                 Toast.makeText(activity_GPS_manual.this, "Falta dados a inserir", Toast.LENGTH_SHORT).show();
             }
         }

        });
    }
}
