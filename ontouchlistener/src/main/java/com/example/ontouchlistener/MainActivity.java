package com.example.ontouchlistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final HatView hat = new HatView(MainActivity.this);
        hat.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                hat.bitmapX=motionEvent.getX()-80;
                hat.bitmapY=motionEvent.getY()-80;
                hat.invalidate();
                return true;
            }
        });
        RelativeLayout relativeLayout = findViewById(R.id.relativeLayout);
        relativeLayout.addView(hat);
    }
}