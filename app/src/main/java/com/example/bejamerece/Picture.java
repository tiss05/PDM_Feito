package com.example.bejamerece;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.webkit.PermissionRequest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bejamerece.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;


public class Picture extends AppCompatActivity {

    /**
     * A variables which will be used
     * **/

    private static final int CAMERA_REQUEST = 1888;
    private static final int ACTIVITY_SELECT_IMAGE = 1234;
    private ImageView imageView;
    private Button next_confirm;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private Uri filePath;
    TextView show_name;
    EditText et_name;
    String str_name;
    Button next_confirm_info;
    DatabaseReference reff;
    User user;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic);
        this.imageView = (ImageView) this.findViewById(R.id.imageView4);
        next_confirm = (Button) findViewById(R.id.button_nextFoto);
        Button btn_choose_photo = (Button) findViewById(R.id.button_galery);
        btn_choose_photo.setOnClickListener(btnChoosePhotoPressed);
        Button photoButton = (Button) this.findViewById(R.id.button_camera);
        show_name=(TextView) findViewById(R.id.tx_nome2);
        et_name=(EditText) findViewById(R.id.editText_name);
        user=new User();




        /**
         * This method gonna catch the contact with the camera
         * **/
        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                } else {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
            }
        });

        next_confirm.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                reff = FirebaseDatabase.getInstance().getReference().child("User").child("1");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String name = dataSnapshot.child("name").getValue(Personal_Inf.class).toString();
                        String email = dataSnapshot.child("email").getValue().toString();
                        String phone = dataSnapshot.child("number").getValue().toString();
                        show_name.setText(name);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }

                });
                //int viewID=view.getId();
                /*if(viewID==R.id.button_nextFoto){
                    str_name=et_name.getText().toString();

                    show_name.setText(str_name);

                }*/
                Intent intent = new Intent(Picture.this, Confirm.class);
                //str_name=et_name.getText().toString();
                startActivity(intent);
            }
        });
    }
    /**
     * check permissons
     * **/
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }
    /**
     * open image
     * **/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
            super.onActivityResult(requestCode, resultCode, data);

        }

        if (requestCode == ACTIVITY_SELECT_IMAGE && resultCode == Activity.RESULT_OK) {
            filePath = data.getData();
            try {
                Bitmap photo = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(photo);
            } catch (IOException e) {
                e.printStackTrace();
            }

            super.onActivityResult(requestCode, resultCode, data);

        }
    }
    /**
     * open gallery
     * **/
    public View.OnClickListener btnChoosePhotoPressed = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            final int ACTIVITY_SELECT_IMAGE = 1234;
            startActivityForResult(i, ACTIVITY_SELECT_IMAGE);

        }
    };
    /**
     * a try chance to open image from gallery
     * **/
    protected void onActivityResult1 ( int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1234:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String filePath = cursor.getString(columnIndex);
                    cursor.close();


                    Bitmap image = BitmapFactory.decodeFile(filePath);
                }
        }
    }
}