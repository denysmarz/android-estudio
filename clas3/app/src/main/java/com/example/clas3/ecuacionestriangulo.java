package com.example.clas3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class ecuacionestriangulo extends View {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public int getE() {
        return e;
    }

    public int getF() {
        return f;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }

    public void setD(int d) {
        this.d = d;
    }

    public void setE(int e) {
        this.e = e;
    }

    public void setF(int f) {
        this.f = f;
    }


    public ecuacionestriangulo(Context context, int a, int b, int c, int d, int e, int f) {
        super(context);
        this.a = a;//a
        this.b = b;//b
        this.c = c;//c
        this.d = d;//A
        this.e = e;//B
        this.f = f;//C
    }
    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        if(this.a == 0){
            if(this.b !=0 && this.c != 0 && this.d != 0){
                this.a = (int) Math.sqrt(Math.pow(this.b,2)+Math.pow(this.c,2)-2*this.b*this.c*Math.cos(this.d));
            }
        }

        if(this.b == 0){
            if(this.a !=0 && this.c != 0 && this.e != 0){
                this.b = (int) Math.sqrt(Math.pow(this.a,2)+Math.pow(this.c,2)-2*this.a*this.c*Math.cos(this.e));
            }
        }

        if(this.c == 0){
            if(this.a !=0 && this.b != 0 && this.f != 0){
                this.c = (int) Math.sqrt(Math.pow(this.a,2)+Math.pow(this.b,2)-2*this.a*this.b*Math.cos(this.f));
            }
        }

        if(this.d == 0){
            System.out.println("valor a: "+this.a+"valor b: "+this.b+"valor c: "+this.c);

            double angulo = Math.acos((Math.pow(this.a,2)-Math.pow(this.b,2)-Math.pow(this.c,2))/(-2*this.b*this.c));
            this.d = (int) Math.toDegrees(angulo);
            //System.out.println("doble angulo: "+angulo);
            System.out.println("ANGULO A: "+this.d);
        }
        if(this.e == 0){
            double angulo = Math.acos((Math.pow(this.b,2)-Math.pow(this.a,2)-Math.pow(this.c,2))/(-2*this.a*this.c));
            this.e = (int) Math.toDegrees(angulo);
            System.out.println("ANGULO B: "+this.e);
        }
        if(this.f == 0){
            double angulo = Math.acos((Math.pow(this.c,2)-Math.pow(this.a,2)-Math.pow(this.b,2))/(-2*this.a*this.b));
            this.f = (int) Math.toDegrees(angulo);
            System.out.println("ANGULO C: "+this.f);
        }

        //DISTANCIA ENTRE VECTORES
        double d = Math.sqrt(Math.pow(((100)-(100+this.b)),2)-Math.pow(((100)-(100+this.c)),2));
        System.out.println("DISTANCIA: "+d);

        int gradod= (int) ((this.d*d)/90);

        System.out.println("GRADOD: "+gradod);


        //inclinacion inicia en altura star  Y termina base stop X     AB
        canvas.drawLine(100/*+this.e*/,100,100+this.b,100+this.c,paint);

        //altura alter stop Y (max 100)  (minimo 1300)   AC
        canvas.drawLine(100/*+this.e*/,100,100/*+this.d*/,100+this.c,paint);

        //base alter stop X (min 100) (max 900.)   BC
        canvas.drawLine(100/*+this.d*/,100+this.c,100+this.b,100+this.c,paint);


    }
}
