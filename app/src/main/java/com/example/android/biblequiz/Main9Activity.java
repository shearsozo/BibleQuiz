package com.example.android.biblequiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main9Activity extends AppCompatActivity {
    /**
     * Variable to hold the amount of correct answers.
     */
    int correct = 0;
    /**
     * Declare placeholder for user answer in global variables
     */
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    String answer5;
    String answer6;
    String answer7;

    /**
     * Method to reset and navigate to first activity page when button is click.
     */
    public Button startover;
    public void gotopage(){
        startover= (Button)findViewById(R.id.startover);
        startover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //method to reset and uncheck all answers

                Intent agape = new Intent(Main9Activity.this,MainActivity.class);
                startActivity(agape);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        loadAnswerFromMyIntend();
        gotopage();
    }
    /**
     * Calculates the results of all questions


    /**
     * Method call when checkscore button is click
     */
    public void result(View view){
        String result = "You got " + correct + "/7 correct!";
        popToast(result);
    }
    /**
     * Toast message appears when checkscore button is click
     */
    private void popToast(String msg) {
        Context context = getApplicationContext();
        CharSequence text = msg;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    
    public void startover(View view) {
        correct = 0;

    }
    public void loadAnswerFromMyIntend(){
        answer1 = getIntent().getStringExtra("answer1");
        answer2 = getIntent().getStringExtra("answer2");
        answer3 = getIntent().getStringExtra("answer3");
        answer4 = getIntent().getStringExtra("answer4");
        answer5 = getIntent().getStringExtra("answer5");
        answer6 = getIntent().getStringExtra("answer6");
        answer7 = getIntent().getStringExtra("answer7");
    }

}
