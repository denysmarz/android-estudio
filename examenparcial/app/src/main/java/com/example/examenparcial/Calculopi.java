package com.example.examenparcial;

import android.content.Context;
import android.view.View;

public class Calculopi extends View {
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
    public Calculopi(Context context, int a) {
        super(context);
        this.a = a;
    }


}
