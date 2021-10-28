package com.example.testapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Activity extends AppCompatActivity {
    EditText Email,Password;
    Button Login;
    FirebaseAuth mFirebase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
          Email = findViewById(R.id.edt_Email);
        Password = findViewById(R.id.edt_Password);
        Login = findViewById(R.id.btn_Login);

        mFirebase = FirebaseAuth.getInstance();


        String email = Email.getText().toString().trim();
        String password = Password.getText().toString().trim();

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate_Email();
                //validate_Password();

            }
        });

    }
    void connect(String email , String password){
        mFirebase.signInWithEmailAndPassword(email, password).addOnCompleteListener(Login_Activity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(Login_Activity.this, "sign up unsucceful please try again", Toast.LENGTH_SHORT).show();


                } else {


                    Intent i = new Intent(getApplicationContext(),TestActivity.class);

                    startActivity(i);
                }
            }
        });
    }
    void validate_Email(){
        String email = Email.getText().toString().trim();

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email.matches(emailPattern) && email.length() > 0)
        {
            Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
            validate_Password();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Invalid email address",Toast.LENGTH_SHORT).show();
            //or
            Email.setError("invalid email");
        }
    }
    void validate_Password(){
        String password = Password.getText().toString().trim();
        String email = Email.getText().toString().trim();

        if (!password.isEmpty() && password.length() > 0)
        {
            connect(email,password);

        }
        else
        {
            Toast.makeText(getApplicationContext(),"Invalid password ",Toast.LENGTH_SHORT).show();
            //or
            Password.setError("invalid password");
        }
    }
}