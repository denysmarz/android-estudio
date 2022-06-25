package com.example.myapplication;

public class operaciones {
    private int a;
    private int b;

    public operaciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

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
    public int suma(){
        return this.a +this.b;
    }
    public int resta(){
        return this.a -this.b;
    }
    public int multiplicar(){
        return this.a *this.b;
    }
    public int dividir(){
        return this.a /this.b;
    }
}
