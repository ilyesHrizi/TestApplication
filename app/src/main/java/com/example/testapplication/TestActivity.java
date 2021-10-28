package com.example.testapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testapplication.SQLlite.CalculateDao;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TestActivity extends AppCompatActivity {
    EditText poid, taille;
    Button calculate,location;
    TextView resultat , value;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Double poid_1,taille_1;
    CalculateDao calculateDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        calculateDao = new CalculateDao(this);

        FirebaseApp.initializeApp(TestActivity.this);

        poid = findViewById(R.id.edt_Poid);
        taille = findViewById(R.id.edt_Taille);
        calculate = findViewById(R.id.Caluclate);
        resultat = findViewById(R.id.tx_Result);
        value = findViewById(R.id.tx_Value);
        location=findViewById(R.id.Location);
        firebaseDatabase = FirebaseDatabase.getInstance("https://testapplication-f100d-default-rtdb.firebaseio.com/");
        databaseReference = firebaseDatabase.getReference();

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Location.class);
                startActivity(i);
            }
        });
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkField();

            }
        });

    }
    public void checkField(){

        //value.setText(taille_1.toString());
        if (poid.getText().toString().isEmpty())
        {
            poid.setError("Poid is Empty");
        }
        else if(taille.getText().toString().isEmpty()){
            taille.setError("taille is Empty");

        }
        else{
            poid_1 =Double.parseDouble(poid.getText().toString());
            //é resultat.setText(poid_1.toString());

            taille_1 = Double.parseDouble(taille.getText().toString());
            if(!(poid_1>=10 && poid_1<250)){
                poid.setError("Poid is out of boundary");
            }
            else if(!(taille_1>=1.0 && taille_1<3.0)){
                taille.setError("taille is out of boundary");
            }

            else{
                CaluclateImc(poid_1,taille_1);
            }
        }
    }

    private void CaluclateImc(Double poid_1,Double taille_1) {

        TestObj testObj = new TestObj();
        resultat.setText(testObj.Calculate_IMC(poid_1,taille_1));
        resultat.setTextColor(testObj.getColor());
        value.setText(testObj.getRes().toString());
        TestObj testObj1 = new TestObj(poid_1,taille_1,testObj.getRes());
        databaseReference.child("Calculate").push().setValue(testObj1);

        boolean d=  calculateDao.insert(testObj1);
        if (d==true){
            Toast.makeText(TestActivity.this,"inserted",Toast.LENGTH_SHORT).show();
        }
        else
        {  Toast.makeText(TestActivity.this,"not inserted",Toast.LENGTH_SHORT).show();}
    }
}
