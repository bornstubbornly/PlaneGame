package com.example.planegame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by 沉鸣 on 2020/3/11.
 */

public class MyplaneView  extends View{
    public float bitmapX;
        public float bitmapY;
        public MyplaneView(Context context) {
            super(context);
            bitmapX=500;
            bitmapY=500;
        }
        protected void onDraw(Canvas canvas){

            super.onDraw(canvas);
            Paint paint=new Paint();
            Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(), R.drawable.plane);
            bitmap=Bitmap.createScaledBitmap(bitmap,300,300,true);
            canvas.drawBitmap(bitmap,bitmapX,bitmapY,paint);
            if(bitmap.isRecycled()){
                bitmap.recycle();
            }

        }
}


