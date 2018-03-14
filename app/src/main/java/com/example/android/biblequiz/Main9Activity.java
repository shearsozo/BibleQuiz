package com.example.android.biblequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main9Activity extends AppCompatActivity {
    /**
     * Variable to hold the amount of correct answers.
     */
    int correct = 0;
    /**
     * Method to navigate to next activity page when button is click.
     */
    public Button startover;
    public void gotopage(){
        startover= (Button)findViewById(R.id.startover);
        startover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agape = new Intent(Main9Activity.this,MainActivity.class);
                startActivity(agape);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        gotopage();
    }
    /**
     * Calculates the results of all questions
     */
    public void calculateResult() {
        questionOne();
        questionTwo();
        questionThree();
        questionFour();
        questionFive();
        questionSix();
        questionSeven();
    }
    /**
     * Method call when checkscore button is click
     */
    public void result(View view) {
        calculateResult();
        String result = "You got " + correct + "/7 correct!";
    }
    /**
     * Toast message appears when checkscore button is click
     * need help here
     */

    /**
     * Method uncheck all check answers and clear all editText, and reset correct variable to 0
     * need help here
     */
    public void startover(View view) {
        correct = 0;

    }

}
