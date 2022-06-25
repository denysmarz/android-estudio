package com.example.examenparcial;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Rectangulo extends View {
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

    public Rectangulo(Context context, int a, int b) {
        super(context);
        this.a = a;
        this.b = b;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int x = this.a;
        int y = this.b;

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        paint.setStrokeWidth(5);
        //inclinacion inicia en altura star  Y termina base stop X
        canvas.drawLine(100,100,100+y,100,paint);

        //altura alter stop Y (max 100)  (minimo 1300)
        canvas.drawLine(100,100,100,100+x,paint);

        //base alter stop X (min 100) (max 900.)
        canvas.drawLine(100,100+x,100+y,100+x,paint);
        //base
        canvas.drawLine(100+y,100+x,100+y,100,paint);

    }


}
