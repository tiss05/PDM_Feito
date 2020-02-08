package com.example.bejamerece;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Confirm extends AppCompatActivity {
    TextView show_name;
    EditText et_name;
    String str_name,st;
    Button next_confirm_info, btn;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        show_name = (TextView) findViewById(R.id.tx_nome);
        //et_name = (EditText) findViewById(R.id.editText_name);
        //btn = findViewById(R.id.button_nextFoto);
        //st = getIntent().getExtras().getString("ABC");
        //show_name.setText(st);



        reff = FirebaseDatabase.getInstance().getReference().child("User").child("1");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("name").getValue().toString();
                //String email = dataSnapshot.child("email").getValue().toString();
                //String phone = dataSnapshot.child("number").getValue().toString();
                show_name.setText(name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
        }



    /*next_confirm_info.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            int viewID=v.getId();
            if(viewID==R.id.button_nextFoto){
                str_name=et_name.getText().toString().trim();

                show_name.setText(str_name);

            }

            //Intent intent = new Intent(Picture.this, Confirm.class);
            //startActivity(intent);
        }
    });*/

    //next_confirm.setOnClickListener(new View.OnClickListener() {
}



