package com.example.testapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void email_isCorrect() {
        Login login = new Login("ilyeshrizi6gmail.com","12345fqdfsqdf@5sd5f");
        login.ValidationEmail(login.getEmail());
        assertEquals("valid Email field", login.ValidationEmail(login.getEmail()));
    }
    @Test
    public void password_isCorrect() {
        Login login = new Login("ilyeshrizi60mail.com","");
        assertEquals("valid password field", login.ValidationPassword(login.getPassword()));
    }


    @Test
    public void Calculate_IMC_1(){
        TestObj testObj = new TestObj();
        assertEquals("Maigeur", testObj.Calculate_imc(80,1.8));
    }
    @Test
    public void Calculate_IMC_2(){
        TestObj testObj = new TestObj();
        assertEquals("Normal", testObj.Calculate_imc(80,1.80));
    }
    @Test
    public void Calculate_IMC_3(){
        TestObj testObj = new TestObj();
        assertEquals("obesite massive", testObj.Calculate_imc(80,1.50));
    }
    @Test
    public void Calculate_IMC_4(){
        TestObj testObj = new TestObj();

        assertEquals("obesite massive", testObj.Calculate_imc(90,1.9));
    }
    @Test
    public void Calculate_IMC_5(){
        TestObj testObj = new TestObj();
        assertEquals("surpoids", testObj.Calculate_imc(90,1.9));
    }
    @Test
    public void Calculate_IMC_6(){
        TestObj testObj = new TestObj();
        assertEquals("Normal", testObj.Calculate_imc(250,2.2));
    }
}