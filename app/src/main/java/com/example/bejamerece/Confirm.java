package com.example.bejamerece;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Confirm extends AppCompatActivity {
    TextView show_name, show_email, show_telefone, show_morada;
    ImageView show_fotografia;
    EditText et_name;
    String str_name,st;
    Button next_confirm_info, btn;
    DatabaseReference reff_pers_info, reff_morada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        show_name = (TextView) findViewById(R.id.confirm_nome);
        show_email = (TextView) findViewById(R.id.confirm_email);
        show_telefone = (TextView) findViewById(R.id.confirm_telefone);
        show_morada = (TextView) findViewById(R.id.confirm_morada);
        show_fotografia = (ImageView) findViewById(R.id.confirm_foto);
        //this.show_fotografia = (ImageView) this.findViewById(R.id.imageView_finalFoto);


        reff_pers_info = (FirebaseDatabase.getInstance().getReference().child("User").child("User02").child("Pers_Info"));
        reff_pers_info.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                /*String name = dataSnapshot.child("name").getValue().toString();
                String email = dataSnapshot.child("email").getValue().toString();
                String phone = dataSnapshot.child("number").getValue().toString();*/
                show_name.setText(user.getName());
                show_email.setText(user.getEmail());
                show_telefone.setText(user.getNumber());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

        reff_morada = (FirebaseDatabase.getInstance().getReference().child("User").child("User02").child("Morada"));
        reff_morada.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                show_morada.setText(user.getLocalidade() + " , " + user.getFreguesia() + " , " + user.getRua());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

        show_fotografia.setImageBitmap(BitMapHelper.getInstance().getBitmap());
    }
}



