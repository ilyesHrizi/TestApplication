package com.example.testapplication.SQLlite;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.testapplication.TestObj;

public class CalculateDao {
    //Attributes
    public static final String CREATE_TABLE = "create table calculate ( taille TEXT, poid TEXT,resultat TEXT);" ;
    public static final String DROP_TABLE="DROP TABLE IF EXISTS calculate ";
    public DataBaseHandler dbHandler;
    //Constructor
    public CalculateDao(Context context) {
        dbHandler = new DataBaseHandler(context,"", null,1);
    }
    //Insert data
    public boolean insert (TestObj e)  {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("taille" , e.getT());
        values.put("poid", e.getP());
        values.put("resultat", e.getRes());
        // Insertion Ligne (Row)
        db.insert("calculate", null, values);
        //db.close(); // fermer la connection BDx
        return true;
    }
    //Delete data
  /*  public Boolean deletedata(Integer first) {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        db.delete("iset","id='"+first+"'",null);
        return true;
    }*/
    //Show data
    /*public Cursor showdata() {
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String req="SELECT * FROM iset";
        Cursor c=db.rawQuery(req,null);
        return c;
    }*/
    /*public Cursor SHEARCH(String nom) {
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String req="SELECT * FROM iset where lnom ='"+nom+"'";
        Cursor c=db.rawQuery(req,null);
        return c;
    }*/
}