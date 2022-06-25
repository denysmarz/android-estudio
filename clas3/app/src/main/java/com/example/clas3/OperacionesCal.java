package com.example.clas3;

import java.io.Serializable;

public class OperacionesCal implements Serializable {

        private int tope,max;
        private String pila[];

        public OperacionesCal(int m)
        {
            max=20;
            pila=new String[max];
            tope=0;
        }

        //Metodo que agrega un dato
        public void Agregar(String n)
        {
            if(tope<max)
            {
                pila[tope]=n;
                tope++;
               // System.out.println("Dato agregado");
            }
            else
            {
                System.out.println("Ya no caben mas datos");
            }
        }
        public void Mostrar()
        {

            for(int a=(tope-1);a>=0;a--)
            {
                System.out.println(pila[a]);
            }
        }

    public void Eliminar()
    {
        for(int a=(tope-1);a>=0;a--)
        {
            tope--;
            System.out.println("Dato eliminado");
        }

    }

    public String Calcular(){
        int bandera = 0;
        String num="";
        String operador="";
        String opaux="";
        int num1 = 0,num2=0,resultado=0;
        pila[tope]="+";
        tope++;
        //pila[tope]=pila[tope-2];
        //tope++;

        //BUSCADOR DE / Y *

        for(int a=(tope-1);a>=0;a--)
        {
            if(pila[a].equals("/")) {
                System.out.println("Dato encontrado -> /");
                resultado=Integer.parseInt(pila[a-1])/Integer.parseInt(pila[a+1]);
                System.out.println("RESULADO /="+resultado+" OPERACION = "+pila[a-1]+" / "+pila[a+1]);
                pila[a] = "+";
                pila[a-1] = String.valueOf(resultado);
                pila[a+1] = "0";
                resultado = 0;
            }
        }

        for(int a=(tope-1);a>=0;a--)
        {
            if(pila[a].equals("*")) {
                System.out.println("Dato encontrado -> *");
                resultado=Integer.parseInt(pila[a-1])*Integer.parseInt(pila[a+1]);
                System.out.println("RESULADO /="+resultado+" OPERACION = "+pila[a-1]+" / "+pila[a+1]);
                pila[a] = "+";
                pila[a-1] = String.valueOf(resultado);
                pila[a+1] = "0";
                resultado = 0;
            }
        }




        for(int a=(tope-1);a>=0;a--)
        {
            System.out.println("HOLASSSSSS");
            if(bandera == 1)
            {
                System.out.println("VALOR DE PILA: "+pila[a]);
                //if(num1 != 0 ){

                  //  System.out.println("esto no derias ver");
                //}
               // if(operador =="+"){
                   // resultado = resultado + num1;
                  //  num1=0;
               // }
                 //  resultado=num1;
                   // System.out.println("ENTRO AL IF");
                    num = pila[a];
                    num1 = Integer.parseInt(num);
                    System.out.println("EL DATO AGREGADO ES: "+num1);

                    if(operador =="+"){
                        if (a>0) {
                            opaux = pila[a - 1];
                            if (opaux == "-") {
                                num1 = num1 * (-1);
                                pila[a-1]="+";
                            }
                        }
                        System.out.println("la suma: "+resultado+operador+num1);
                        resultado = resultado + num1;
                        //num1=0;
                    }
                if(operador =="-"){

                    if (a>0){
                        opaux=pila[a-1];
                        if (opaux=="-"){
                            num1=num1*(-1);
                            System.out.println("num1; "+num1);
                        }

                    }

                    if (resultado<0){
                        resultado=resultado*(-1);
                    }
                    System.out.println("la op es: "+num1+operador+resultado);

                    resultado = num1 - resultado;
                    System.out.println("resultado parcial: "+resultado);
                   // num1=0;
                }


                bandera = 0;
            }else{
                operador = pila[a];
                System.out.println("el OPERADOR ES: "+operador);
                bandera = 1;
            }

           // System.out.println(pila[a]);
        }

        return resultado+"";
    }

}
