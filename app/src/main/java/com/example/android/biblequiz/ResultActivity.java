package com.example.android.biblequiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    /**
     * Method to reset and navigate to first activity page when button is click.
     */
    public Button startover;
    /**
     * Variable to hold the amount of correct answers.
     */
    int correct;
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

    public void gotopage() {
        Log.v("start_button", "function called");
        startover = (Button) findViewById(R.id.startover);
        startover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ResultActivity.this, StartActivity.class);

                startActivity(i);
            }
        });
    }
    private static final int questions_number = 7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        loadAnswerFromMyIntend();


        /**
         * Method to calculate score
         */
        correct = calculateFinalScore();
        if (correct < questions_number) {
            String scoreMessage = "You got " + Integer.toString(correct) + " out of 7 correct!";
            popToast(scoreMessage);
        }
        else {
            String scoreMessage = "Wow! You got all answers correct!";
            popToast(scoreMessage);
        }
        gotopage();
    }


    /**
     * pop up toast message
     */
    private void popToast(String msg) {
        Context context = getApplicationContext();
        CharSequence text = msg;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    //here's how to check score
    public int calculateFinalScore() {
        int myResult = 0;
        //if the answer for the first question is the third radio button, then increment by 1
        //radio button answers are index position which starts from 0
        if (Integer.valueOf(answer1) == 2)
            myResult++;
        if (answer2.equals("1|2|3|4"))
            myResult++;
        if (Integer.valueOf(answer3) == 1)
            myResult++;
        if (answer4.equalsIgnoreCase("God"))
            myResult++;
        if (answer5.equals("1|2||4"))
            myResult++;
        if (answer6.equalsIgnoreCase("world"))
            myResult++;
        if (Integer.valueOf(answer7) == 3)
            myResult++;
        return myResult;
    }

    /**
     * reload answers from intent
     */
    public void loadAnswerFromMyIntend() {
        answer1 = getIntent().getStringExtra("answer1");
        answer2 = getIntent().getStringExtra("answer2");
        answer3 = getIntent().getStringExtra("answer3");
        answer4 = getIntent().getStringExtra("answer4");
        answer5 = getIntent().getStringExtra("answer5");
        answer6 = getIntent().getStringExtra("answer6");
        answer7 = getIntent().getStringExtra("answer7");
    }
}
