package com.example.bejamerece;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Personal_Inf extends AppCompatActivity {
    private Button next;
    private EditText info_name, info_email, info_telefone;
    //FirebaseDatabase database;
    DatabaseReference reff;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_inf);

        next = (Button) findViewById(R.id.button_confirmar_dados);
        info_name=(EditText) findViewById(R.id.editText_name);
        info_email=(EditText) findViewById(R.id.editText_email);
        info_telefone=(EditText) findViewById(R.id.editText_phone);
        user=new User();
        //database=FirebaseDatabase.getInstance();
        reff= FirebaseDatabase.getInstance().getReference().child("User");


        /**
         * change window
         * **/

        next.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                //int phn = Integer.parseInt(info_telefone.getText().toString().trim());

                user.setName(info_name.getText().toString().trim());
                user.setEmail(info_email.getText().toString().trim());
                user.setNumber(info_telefone.getText().toString().trim());

                reff.child("User02").setValue(user);
                Toast.makeText(Personal_Inf.this, "Dados inseridos com sucesso", Toast.LENGTH_SHORT).show();



                //String email = Integer.parseInt(info_name.getText().toString().trim());
                Intent intent = new Intent(Personal_Inf.this, Picture.class);
                //intent.putExtra("abc",Data_name);
                startActivity(intent);
            }
        });


    }




}

