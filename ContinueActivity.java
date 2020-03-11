package com.example.planegame;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * Created by 沉鸣 on 2020/3/10.
 */


public class ContinueActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private int mProgress=0;
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全局显示
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        mHandler=new Handler(){
            public void handleMessage(Message msg){
                if(msg.what==0x111){
                    progressBar.setProgress(mProgress);
                }else{
                    Toast.makeText(ContinueActivity.this,"加载完成",Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                    Intent intent=new Intent(ContinueActivity.this,MyplaneActivity.class);
                    startActivity(intent);
                }
            }
        };
        new Thread(new Runnable(){
            public void run(){
                while(true){
                    try {
                        mProgress=doWork();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message m=new Message();
                    if(mProgress<30){
                        m.what=0x111;
                        mHandler.sendMessage(m);
                    }else{
                        m.what=0x110;
                        mHandler.sendMessage(m);
                        break;
                    }
                }
            }
            private int doWork() throws InterruptedException {
                mProgress+=Math.random()*10;
                Thread.sleep(600);
                return mProgress;
            }
        }).start();
    }
}
