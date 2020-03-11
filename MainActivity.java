package com.example.planegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String number;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login=(Button)findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                EditText editTextnumber=(EditText)findViewById(R.id.number);
                number=editTextnumber.getText().toString();
                EditText editTextpassword=(EditText)findViewById(R.id.password);
                password=editTextpassword.getText().toString();
                if(number.equals("")){
                    Toast.makeText(MainActivity.this, "请输入果果号", Toast.LENGTH_SHORT).show();
                }
                if(!number.equals("1300530529")) {
                    Toast.makeText(MainActivity.this, "该用户不存在", Toast.LENGTH_SHORT).show();
                }
                if(number.equals("1300530529")&&!password.equals("0123456")) {
                    Toast.makeText(MainActivity.this, "密码输入错误！", Toast.LENGTH_SHORT).show();
                }
                if(number.equals("1300530529")&&password.equals("0123456")) {
                    Toast.makeText(MainActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,ContinueActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
