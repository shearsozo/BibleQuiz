package com.example.android.biblequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Main6Activity extends AppCompatActivity {
    /**
     * Variable to hold the amount of correct answers.
     */
    int correct = 0;
    CheckBox q5a_correct;
    CheckBox q5b_correct;
    CheckBox q5c_correct;
    CheckBox q5d_correct;
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
    public Button next5;
    public Button previous5;
    public void gotopage(){
        next5= (Button)findViewById(R.id.next5);
        previous5= (Button)findViewById(R.id.previous5);
        next5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                answer5 = getCheckBoxAnswers();
                Log.v("set_answer", "answer1:" + answer1);
                Log.v("set_answer", "answer2:" + answer2);
                Log.v("set_answer", "answer3:" + answer3);
                Log.v("set_answer", "answer4:" + answer4);
                Log.v("set_answer", "answer5:" + answer5);
                Log.v("set_answer", "answer6:" + answer6);
                Log.v("set_answer", "answer7:" + answer7);
                Intent agape = new Intent(Main6Activity.this,Main7Activity.class);
                dressUpIntent(agape);
            }
        });
        previous5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer5 = getCheckBoxAnswers();
                Log.v("set_answer", "answer1:" + answer1);
                Log.v("set_answer", "answer2:" + answer2);
                Log.v("set_answer", "answer3:" + answer3);
                Log.v("set_answer", "answer4:" + answer4);
                Log.v("set_answer", "answer5:" + answer5);
                Log.v("set_answer", "answer6:" + answer6);
                Log.v("set_answer", "answer7:" + answer7);
                Intent agape = new Intent(Main6Activity.this,Main5Activity.class);
                dressUpIntent(agape);
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        // only checkbox a, b, d is correct
        q5a_correct = findViewById(R.id.checkanswer5a);
        q5b_correct = findViewById(R.id.checkanswer5b);
        q5c_correct = findViewById(R.id.checkanswer5c);
        q5d_correct = findViewById(R.id.checkanswer5d);
        /**
         * reload the answer from intend
         */
        Log.v("load_answer", "load from intent at main6");
        loadAnswerFromMyIntend();
        Log.v("load_answer", "answer1:" + answer1);
        Log.v("load_answer", "answer2:" + answer2);
        Log.v("load_answer", "answer3:" + answer3);
        Log.v("load_answer", "answer4:" + answer4);
        Log.v("load_answer", "answer5:" + answer5);
        Log.v("load_answer", "answer6:" + answer6);
        Log.v("load_answer", "answer7:" + answer7);
        if(answer5 !=null) reloadCheckBoxFromUserAnswer(answer5);
        gotopage();
    }
    /**
     This function will put all 7 answers into intent using the following syntax
     myIntend.putExtra(“key”, “value”) //both key and value are string types
     then called calling this when you go to both next page and previous page
     startActivity(myIntent);
     */
    public void dressUpIntent(Intent vMyIntend){
        //putting my key value pair
        //for example, key for first item is "answer1 and the value that variable answer1 holds
        vMyIntend.putExtra("answer1",    answer1);
        vMyIntend.putExtra("answer2",    answer2);
        vMyIntend.putExtra("answer3",    answer3);
        vMyIntend.putExtra("answer4",    answer4);
        vMyIntend.putExtra("answer5",    answer5);
        vMyIntend.putExtra("answer6",    answer6);
        vMyIntend.putExtra("answer7",    answer7);
        startActivity(vMyIntend);
    }
    /**
     load the answer from each intend
     */
    public void loadAnswerFromMyIntend(){
        answer1 = getIntent().getStringExtra("answer1");
        answer2 = getIntent().getStringExtra("answer2");
        answer3 = getIntent().getStringExtra("answer3");
        answer4 = getIntent().getStringExtra("answer4");
        answer5 = getIntent().getStringExtra("answer5");
        answer6 = getIntent().getStringExtra("answer6");
        answer7 = getIntent().getStringExtra("answer7");
    }
    /**
     * check if each checkbox is checked, if so, concatenate the answer.
     * i.e. if checkbox1 is checked, then you have "1" and so on.
     * Then if you have 4 checkbox and checkbox 1,2,4 are checked, you would be
     * using something like "1|2|4" .
     * This way, when you calculate score for checkbox, you only need to check
     * if the string matches with your answer.
     * In this case only checkbox c is the only not correct.
     */
    public String getCheckBoxAnswers(){
        String q5Answer = "";
        if(q5a_correct.isChecked())
            q5Answer = "1";
        q5Answer = q5Answer + "|";
        if(q5b_correct.isChecked())
            q5Answer = q5Answer + "2";
        q5Answer = q5Answer + "|";

        if(q5c_correct.isChecked())
            q5Answer = q5Answer + "3";
        q5Answer = q5Answer + "|";
        if(q5d_correct.isChecked())
            q5Answer = q5Answer + "4";
        return q5Answer;
    }
    /**
     * This method takes in a checkbox and user's answer string "1|2||4"
     * if user previously check answer 1, 2 and 4,
     * and check against the questionIndex, which is the specific answer choice,
     * and checks the checkbox if it exist.
     */
    public void markCheckBoxSelection(CheckBox vMyCheckBox, String userAnswer, String answerIndex){
        if (userAnswer.contains(answerIndex)) vMyCheckBox.setChecked(true);
    }
    /**
     * This method will use the markCheckBoxSelection to check against all the checkboxes
     */
    public void reloadCheckBoxFromUserAnswer(String userAnswer){
        markCheckBoxSelection(q5a_correct, userAnswer, "1" );
        markCheckBoxSelection(q5b_correct, userAnswer, "2" );
        markCheckBoxSelection(q5c_correct, userAnswer, "3" );
        markCheckBoxSelection(q5d_correct, userAnswer, "4" );
    }
}