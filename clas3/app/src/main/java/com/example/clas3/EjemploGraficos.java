package com.example.clas3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class EjemploGraficos extends View {

    private static final String TAG = "MISDATOS";

    public EjemploGraficos(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint paint = new Paint();

        //for(int i=0;i<=300;i++){
            ///paint.setColor(Color.rgb(20*i,30*i,40*i));
            //canvas.drawCircle(10+(i*2),10+(i*3),20,paint);
       // }

        int ancho = getWidth();
        int alto = getHeight();
        float limInfx = -20;
        float limSupx = 20;
        float limInfy = -20;
        float limSupy = 20;

        Log.i(TAG,"ancho = "+ancho+" alto = "+alto); //ancho = 1080 alto = 1584
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        canvas.drawLine(0,alto/2,ancho,alto/2,paint);
        canvas.drawLine(ancho/2,0,ancho/2,alto,paint);
        paint.setColor(Color.BLUE);
        for (float x= limInfx;x<=limSupx;x+=0.02){
            float y = (float)fx(x);
            float tx = ((x-limInfx)*ancho)/(limSupx-limInfx);
            float ty = alto - ((y-limInfy)*alto)/(limSupy-limInfy);
            canvas.drawCircle(tx,ty,4,paint);
        }
    }

    private double fx(float x){
        return x*Math.sin(x);
    }
}
