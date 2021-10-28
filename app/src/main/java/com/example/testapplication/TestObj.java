package com.example.testapplication;

import android.graphics.Color;

public class TestObj {

    private Double poid, taille,imc;
    private Double res;
    private int color;


    public TestObj( ){

    }
    public TestObj(double poid,double taille ){
        this.poid = poid;
        this.taille = taille;
    }
    public TestObj(double poid,double taille,double res ){
        this.poid = poid;
        this.taille = taille;
        this.res = res;
    }
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Double getP() {
        return poid;
    }

    public void setP(Double p) {
        poid = p;
    }

    public Double getT() {
        return taille;
    }

    public void setT(Double t) {
        taille= t;
    }

    public Double getRes() {
        return res;
    }

    public void setRes(Double res) {
        res = res;
    }
        public String Calculate_IMC (double P , double T){
            T = (float)Math.pow(T, 2);
            res = P/T; //Calcule de l'IMC
//            res = (Float) Math.round(res*100)/100;
            //res = P /(T*T);
            String result = "";
            if(res < 18.5)
            {

                result = "Maigeur";
                color = Color.rgb(135,206,250	);
            }
           else if(res > 18.5 && res <= 24.9)
            {

                result = "Normal";
                color = Color.rgb(30,144,255	);
            }
           else  if(res > 24.9 && res <= 29.9)
            {

                result = "surpoids";
                color = Color.rgb(255,165,0) ;
            }
          else  if(res > 29.9 && res <= 40)
            {
                result = "obesite";
               //color =  Color.rgb(255,69,0);

            }
           else
            {
                result = "obesite massive";
                color =Color.rgb(255,0,0);

            }
            return result;
        }
    public String Calculate_imc (double P , double T){
        T = (float)Math.pow(T, 2);
        res = P/T; //Calcule de l'IMC
//            res = (Float) Math.round(res*100)/100;
        //res = P /(T*T);
        String result = "";
        if(res < 18.5)
        {

            result = "Maigeur";
            //color = Color.rgb(135,206,250	);
        }
        else if(res > 18.5 && res <= 24.9)
        {

            result = "Normal";
           // color = Color.rgb(30,144,255	);
        }
        else  if(res > 24.9 && res <= 29.9)
        {

            result = "surpoids";
           // color = Color.rgb(255,165,0) ;
        }
        else  if(res > 29.9 && res <= 40)
        {
            result = "obesite";
            //color =  Color.rgb(255,69,0);

        }
        else
        {
            result = "obesite massive";
            //color =Color.rgb(255,0,0);

        }
        return result;
    }
}
