package com.example.gesture;

import androidx.appcompat.app.AppCompatActivity;

import android.gesture.Gesture;
import android.media.Image;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;
//第一步：让MainActivity实现GestureDetector.OnGestureListener接口，并实现其所有方法
public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    Animation[] animation = new Animation[4];
    final int distance = 50;
    private int[] images = new int[]{
            R.drawable.image1,R.drawable.image2,R.drawable.image3,
            R.drawable.image4,R.drawable.image5,
    };
    //第二步：定义一个全局的手势检测器
    GestureDetector detector;
    ViewFlipper flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        detector = new GestureDetector(MainActivity.this,this);
        //第三步：将要显示的图片加载到ViewFliper中，并且初始化数组
        flipper=findViewById(com.google.android.material.R.id.flip);//原视频是（R.id.flipper）不知道那里来的
        for(int i=0;i<images.length;i++){
            ImageView imageView=new ImageView(this);
            imageView.setImageResource(images[i]);
            flipper.addView(imageView);
        }
        //动画xml文件（4行）
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        //第四步：在onFling()方法中通过触摸事件的X坐标判断是向左滑动还是向右滑动，并且为其设定动画

        if(motionEvent.getX()-motionEvent1.getX()>distance){
            flipper.setInAnimation(animation[2]);
            flipper.setOutAnimation(animation[1]);
            flipper.showPrevious();
            return true;
        }else if(motionEvent1.getX()-motionEvent.getX()>distance){
            flipper.setInAnimation(animation[0]);
            flipper.setOutAnimation(animation[3]);
            flipper.showPrevious();
            return true;
        }
        return false;
    }
    //第5步：将Activity上的触摸事件交给Gesture Detector处理

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }
}