package com.example.android.biblequiz;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {
    /**
     * Method to navigate to different activity page when button is click.
     */
    public Button next3;
    public Button previous3;
    /**
     * Variable to hold the amount of correct answers.
     */
    int correct = 0;
    RadioButton q3_correct;
    RadioGroup q3_rGroup;
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
        next3 = (Button) findViewById(R.id.next3);
        previous3 = (Button) findViewById(R.id.previous3);
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get the index of the checked radio group and cast to string
                answer3 = String.valueOf(getRadioButtonSelection(q3_rGroup));
                Log.v("set_answer", "answer1:" + answer1);
                Log.v("set_answer", "answer2:" + answer2);
                Log.v("set_answer", "answer3:" + answer3);
                Log.v("set_answer", "answer4:" + answer4);
                Log.v("set_answer", "answer5:" + answer5);
                Log.v("set_answer", "answer6:" + answer6);
                Log.v("set_answer", "answer7:" + answer7);
                Intent agape = new Intent(Main4Activity.this, Main5Activity.class);
                dressUpIntent(agape);
            }
        });
        previous3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer3 = String.valueOf(getRadioButtonSelection(q3_rGroup));
                Log.v("set_answer", "answer1:" + answer1);
                Log.v("set_answer", "answer2:" + answer2);
                Log.v("set_answer", "answer3:" + answer3);
                Log.v("set_answer", "answer4:" + answer4);
                Log.v("set_answer", "answer5:" + answer5);
                Log.v("set_answer", "answer6:" + answer6);
                Log.v("set_answer", "answer7:" + answer7);
                Intent agape = new Intent(Main4Activity.this, Main3Activity.class);
                dressUpIntent(agape);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        q3_rGroup = findViewById(R.id.rgAnswer3);
        Log.v("load_answer", "load from intent at main4");
        loadAnswerFromMyIntend();
        Log.v("load_answer", "answer1:" + answer1);
        Log.v("load_answer", "answer2:" + answer2);
        Log.v("load_answer", "answer3:" + answer3);
        Log.v("load_answer", "answer4:" + answer4);
        Log.v("load_answer", "answer5:" + answer5);
        Log.v("load_answer", "answer6:" + answer6);
        Log.v("load_answer", "answer7:" + answer7);
        /*
        If answer3 has some answer, then preselect.
         */
        if (answer3 != null) {
            int intAnswer1 = Integer.parseInt(answer3);
            setRadioButtonByIndex(q3_rGroup, intAnswer1);
        }
        gotopage();
    }

    /**
     * This method is called when the answer button is clicked.
     */
    public void showAnswer(View view) {
        TextView textView = (TextView) findViewById(R.id.show_text_view);
        textView.setText("The Matrix");
        textView.setTextColor(Color.RED);
    }

    /**
     * Method to record correct answer for question 3.
     */
    public void questionThree() {
        RadioButton q3_correct = findViewById(R.id.answer3);

        if (q3_correct.isChecked()) {
            correct++;
        }
    }

    /**
     * Pass in the radio button group reference and return the index of the checked radio button
     * This index will be used as the answer
     */
    public int getRadioButtonSelection(RadioGroup vMyRGroup) {
        int index = vMyRGroup.indexOfChild(findViewById(vMyRGroup.getCheckedRadioButtonId()));
        return index;
    }

    /**
     * Pass in the radio button group reference as well as the index of the radio button to check and set it
     */
    public void setRadioButtonByIndex(RadioGroup vMyRGroup, int checkedIndex) {
        ((RadioButton) vMyRGroup.getChildAt(checkedIndex)).setChecked(true);
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