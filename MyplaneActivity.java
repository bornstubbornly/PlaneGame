package com.example.planegame;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by 沉鸣 on 2020/3/11.
 */

public class MyplaneActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameing);
        FrameLayout rl=(FrameLayout) findViewById(R.id.gameing);
        final MyplaneView myplane=new MyplaneView(this);
        myplane.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                myplane.bitmapX=event.getX()-150;
                myplane.bitmapY=event.getY()-150;
                myplane.invalidate();
                return true;
            }
        });
        rl.addView(myplane);
    }
}
