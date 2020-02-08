package com.example.bejamerece;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class choice_local extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton rButton1, rButton2;
    private Button next;
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        /**
         * A group of radio-buttons and a botton to be pressed when the user wants to got next screen
         * **/
        radioGroup = (RadioGroup) findViewById(R.id.rglocal);
        rButton1 = (RadioButton) findViewById(R.id.radioButton_withGPS);
        rButton2 = (RadioButton) findViewById(R.id.radioButton_withoutGPS);
        next = (Button) findViewById(R.id.button_next);

        /**
         * the user can choice if he wnated to choose auto-location or manual-location
         * **/

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rButton1.isChecked())
                {
                    Intent intent = new Intent(choice_local.this, activity_GPS_auto.class);
                    startActivity(intent);
                } else if (rButton2.isChecked())
                {
                    Intent intent = new Intent(choice_local.this, activity_GPS_manual.class);
                    startActivity(intent);
                }
            }

        });
    }

}
