package com.example.bejamerece;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Confirm extends AppCompatActivity {
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        name=(TextView) findViewById(R.id.tx_nome);
    }

    //public void OnClick
}
