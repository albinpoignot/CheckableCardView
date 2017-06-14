package com.example.checkablecardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Checkable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.card_view_pressed).setPressed(true);
        ((Checkable)findViewById(R.id.card_view_checked)).setChecked(true);
    }
}
