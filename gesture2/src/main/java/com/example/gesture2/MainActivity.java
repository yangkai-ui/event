package com.example.gesture2;

import androidx.appcompat.app.AppCompatActivity;

import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GestureOverlayView.OnGestureListener, GestureOverlayView.OnGesturePerformedListener {
    private GestureLibrary library;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        library = GestureLibraries.fromRawResource(MainActivity.this,R.raw.gestures);
        editText = findViewById(R.id.editText);
        if(!library.load()){
            finish();
        }
        GestureOverlayView gestureOverlayView = findViewById(R.id.gesture);
        gestureOverlayView.setGestureColor(Color.BLACK);
        gestureOverlayView.setFadeOffset(1000);
        gestureOverlayView.addOnGesturePerformedListener(this);

    }


    @Override
    public void onGestureStarted(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {

    }

    @Override
    public void onGesture(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {

    }

    @Override
    public void onGestureEnded(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {

    }

    @Override
    public void onGestureCancelled(GestureOverlayView gestureOverlayView, MotionEvent motionEvent) {

    }

    @Override
    public void onGesturePerformed(GestureOverlayView gestureOverlayView, Gesture gesture) {
        ArrayList<Prediction> gestures = library.recognize(gesture);
        int index = 0;
        double score = 0.0;
        for(int i=0;i<gestures.size();i++){
            Prediction result = gestures.get(i);
            if(result.score>score){
                index=i;
                score=result.score;
            }
        }
        String text=editText.getText().toString();
        text+=gestures.get(index).name;
        editText.setText(text);
    }
}