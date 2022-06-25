package com.example.clas3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class Triangulo extends View{
    private int a,b;


    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Triangulo(Context context,int a,int b) {
        super(context);
        this.a = a;
        this.b = b;
        //super(context,a,b);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int x = this.a;
        int y = this.b;

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);


        //inclinacion inicia en altura star  Y termina base stop X
        canvas.drawLine(100,100,100+y,100+x,paint);

        //altura alter stop Y (max 100)  (minimo 1300)
        canvas.drawLine(100,100,100,100+x,paint);

        //base alter stop X (min 100) (max 900.)
        canvas.drawLine(100,100+x,100+y,100+x,paint);

    }

}
//inclinacion
//canvas.drawLine(100,300,600,800,paint);
//altura alter star
//canvas.drawLine(100,300,100,800,paint);
//base alter stop
// canvas.drawLine(100,800,600,800,paint);