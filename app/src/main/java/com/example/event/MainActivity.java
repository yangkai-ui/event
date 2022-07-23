package com.example.event;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

public class MainActivity extends Activity {
    private long exitTime=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public void exit(){
        if((System.currentTimeMillis()-exitTime)>2000){
            Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_LONG).show();
            exitTime=System.currentTimeMillis();
        }else{
            finish();
            System.exit(0);
        }
    }

}