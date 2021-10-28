package com.example.testapplication;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class TestActivityTest extends TestCase {

    @Rule
    public ActivityTestRule<Login_Activity> mActivityTestRule = new ActivityTestRule<Login_Activity>(Login_Activity.class);

    private String mName = "ilyeshrizi60@gmail.com";
    private String nPassword="ilyes123";

    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void testUserInputScenario()
    {

        // input some text in the edit text
        Espresso.onView(withId(R.id.edt_Email)).perform(typeText(mName));


        // checking the text in the textview
        Espresso.onView(withId(R.id.edt_Password)).check(matches(withText(mName)));
        Espresso.onView(withId(R.id.edt_Password)).perform(typeText(nPassword));

        // close soft keyboard
        Espresso.closeSoftKeyboard();
        // perform button click
        Espresso.onView(withId(R.id.btn_Login)).perform(click());


    }

    @Test
    public void testUserInput()
    {

        // input some text in the edit text
        Espresso.onView(withId(R.id.edt_Email)).perform(typeText("mName"));


        // checking the text in the textview
        //Espresso.onView(withId(R.id.edt_Password)).check(matches(withText(mName)));
        Espresso.onView(withId(R.id.edt_Password)).perform(typeText("nPassword"));

        // close soft keyboard
        Espresso.closeSoftKeyboard();
        // perform button click
        Espresso.onView(withId(R.id.btn_Login)).perform(click());


    }


    @After
    public void tearDown() throws Exception {

    }

}