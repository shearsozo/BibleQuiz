package com.example.android.biblequiz;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity {
    /**
     * Variable to hold the amount of correct answers.
     */
    int correct = 0;
    EditText q4_correct;
    String user_answer4;
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
     * Method to navigate to different activity page when button is click.
     */
    public Button next4;
    public Button previous4;

    public void gotopage() {
        next4 = (Button) findViewById(R.id.next4);
        previous4 = (Button) findViewById(R.id.previous4);
        next4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                questionFour();
                Log.v("set_answer", "answer1:" + answer1);
                Log.v("set_answer", "answer2:" + answer2);
                Log.v("set_answer", "answer3:" + answer3);
                Log.v("set_answer", "answer4:" + answer4);
                Log.v("set_answer", "answer5:" + answer5);
                Log.v("set_answer", "answer6:" + answer6);
                Log.v("set_answer", "answer7:" + answer7);
                Intent agape = new Intent(Main5Activity.this, Main6Activity.class);
                dressUpIntent(agape);
            }
        });
        previous4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                questionFour();
                Log.v("set_answer", "answer1:" + answer1);
                Log.v("set_answer", "answer2:" + answer2);
                Log.v("set_answer", "answer3:" + answer3);
                Log.v("set_answer", "answer4:" + answer4);
                Log.v("set_answer", "answer5:" + answer5);
                Log.v("set_answer", "answer6:" + answer6);
                Log.v("set_answer", "answer7:" + answer7);
                Intent agape = new Intent(Main5Activity.this, Main4Activity.class);
                dressUpIntent(agape);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        q4_correct = findViewById(R.id.answer4);
        Log.v("load_answer", "load from intent at main5");
        loadAnswerFromMyIntend();
        Log.v("load_answer", "answer1:" + answer1);
        Log.v("load_answer", "answer2:" + answer2);
        Log.v("load_answer", "answer3:" + answer3);
        Log.v("load_answer", "answer4:" + answer4);
        Log.v("load_answer", "answer5:" + answer5);
        Log.v("load_answer", "answer6:" + answer6);
        Log.v("load_answer", "answer7:" + answer7);
        if (answer4 != null) {
            q4_correct.setText(answer4);
        }
        gotopage();
    }

    /**
     * This method is called when the answer button is clicked.
     */
    public void showAnswer(View view) {
        TextView textView = (TextView) findViewById(R.id.show_text_view);
        textView.setText("God");
        textView.setTextColor(Color.RED);
    }

    /**
     * Method to record correct answer for question 4.
     */
    public void questionFour() {
        EditText q4_correct = findViewById(R.id.answer4);
        answer4 = q4_correct.getText().toString();
    }

    /**
     * This function will put all 7 answers into intent using the following syntax
     * myIntend.putExtra(“key”, “value”) //both key and value are string types
     * then called calling this when you go to both next page and previous page
     * startActivity(myIntent);
     */
    public void dressUpIntent(Intent vMyIntend) {
        //putting my key value pair
        //for example, key for first item is "answer1 and the value that variable answer1 holds
        vMyIntend.putExtra("answer1", answer1);
        vMyIntend.putExtra("answer2", answer2);
        vMyIntend.putExtra("answer3", answer3);
        vMyIntend.putExtra("answer4", answer4);
        vMyIntend.putExtra("answer5", answer5);
        vMyIntend.putExtra("answer6", answer6);
        vMyIntend.putExtra("answer7", answer7);
        startActivity(vMyIntend);
    }

    /**
     * load the answer from each intend
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