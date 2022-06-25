package com.example.clas3;

import java.io.Serializable;

public class Operaciones implements Serializable {
    private float a;
    private float b;
    private float c;
    private float d;

    public Operaciones(float a, float b, float c, float d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public float getC() {
        return c;
    }

    public float getD() {
        return d;
    }

    public void setA(float a) {
        this.a = a;
    }

    public void setB(float b) {
        this.b = b;
    }

    public void setC(float c) {
        this.c = c;
    }

    public void setD(float d) {
        this.d = d;
    }


    public String suma(){
        float rerf = this.a+this.b;
        float reif = this.c+this.d;
        if(reif<0){
            return rerf+" - "+reif*(-1)+"i";
        }
        return rerf+"  +  "+reif+"i";
    }
    public String resta(){
        float rerf = this.a-this.b;
        float reif = this.c-this.d;
        if(reif<0){
            return rerf+" - "+reif*(-1)+"i";
        }
        return rerf+" + "+reif+"i";
    }
    public String multiplicacion(){
        float rerf = (this.a*this.b)-(this.c*this.d);
        float reif = (this.a*this.d)+(this.b*this.c);
        if(reif<0){
            return rerf+" - "+reif*(-1)+"i";
        }
        return rerf+" + "+reif+"i";
    }
    public String division(){
        float rerf = (this.a*this.b)-(this.c*(this.d*(-1)));
        float reif = (this.a*(this.d*(-1)))+(this.b*this.c);

        float denominador = (this.b*this.b)-(this.d*(this.d*(-1)))+(this.b*(this.d*(-1)))+(this.d*this.b);

        if(reif<0){
            return rerf+"/"+denominador+" - "+reif*(-1)+"/"+denominador+"i";
        }

        return rerf+"/"+denominador+"+"+reif+"/"+denominador+"i";
    }
}
