package com.example.testapplication;

import android.widget.Toast;

public class Login {

    private String Email;
    private String password;

    public Login(String email, String password) {
        Email = email;
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "Email='" + Email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    public String ValidationEmail(String Email){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (Email.matches(emailPattern) && Email.length()>0)
        {
                return "valid Email field";
        }
        else
        {
            return "InValid Email field";
        }

    }
    public String ValidationPassword(String Password){

        if (Password.length()>0 & !Password.isEmpty())
        {
            return "valid password field";
        }
        else
        {
            return "InValid password field";
        }

    }
}
