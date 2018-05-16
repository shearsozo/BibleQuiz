package com.example.android.biblequiz;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class Question2Activity extends AppCompatActivity {
    /**
     * Method to navigate to different activity page when button is click.
     */
    public Button next2;
    public Button previous2;
    /**
     * Variable to hold the amount of correct answers.
     */
    CheckBox question2a_correct;
    CheckBox question2b_correct;
    CheckBox question2c_correct;
    CheckBox question2d_correct;
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
        next2 = (Button) findViewById(R.id.next2);
        previous2 = (Button) findViewById(R.id.previous2);
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer2 = getCheckBoxAnswers();

                Intent i = new Intent(Question2Activity.this, Question3Activity.class);
                dressUpIntent(i);
            }
        });
        previous2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer2 = getCheckBoxAnswers();

                Intent i = new Intent(Question2Activity.this, Question1Activity.class);
                dressUpIntent(i);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        question2a_correct = findViewById(R.id.checkanswer2a);
        question2b_correct = findViewById(R.id.checkanswer2b);
        question2c_correct = findViewById(R.id.checkanswer2c);
        question2d_correct = findViewById(R.id.checkanswer2d);
        /**
         * reload the answer from intend
         */
        loadAnswerFromMyIntend();

        if (answer2 != null) reloadCheckBoxFromUserAnswer(answer2);
        gotopage();
    }

    /**
     * This method is called when the answer button is clicked.
     */
    public void showAnswer(View view) {
        TextView textView = (TextView) findViewById(R.id.show_text_view);
        textView.setText("All answers are correct");
        textView.setTextColor(Color.RED);
    }

    /**
     * This function will put all 7 answers into intent using the following syntax
     * myIntend.putExtra(“key”, “value”) //both key and value are string types
     * then calling this when you go to both next page and previous page
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

    /**
     * check if each checkbox is checked, if so, concatenate the answer.
     * i.e. if checkbox1 is checked, then you have "1" and so on.
     * Then if you have 4 checkbox and checkbox 1,2,4 are checked, you would be
     * using something like "1|2|4" .
     * This way, when you calculate score for checkbox, you only need to check
     * if the string matches with your answer.
     */
    public String getCheckBoxAnswers() {
        String q2Answer = "";
        if (question2a_correct.isChecked())
            q2Answer = "1";
        q2Answer = q2Answer + "|";
        if (question2b_correct.isChecked())
            q2Answer = q2Answer + "2";
        q2Answer = q2Answer + "|";
        if (question2c_correct.isChecked())
            q2Answer = q2Answer + "3";
        q2Answer = q2Answer + "|";
        if (question2d_correct.isChecked())
            q2Answer = q2Answer + "4";
        return q2Answer;
    }

    /**
     * This method takes in a checkbox and user's answer string "1|2||4"
     * if user previously check answer 1, 2 and 4,
     * and check against the questionIndex, which is the specific answer choice,
     * and checks the checkbox if it exist.
     */
    public void markCheckBoxSelection(CheckBox vMyCheckBox, String userAnswer, String answerIndex) {
        if (userAnswer.contains(answerIndex)) vMyCheckBox.setChecked(true);
    }

    /**
     * This method will use the markCheckBoxSelection to check against all the checkboxes
     */
    public void reloadCheckBoxFromUserAnswer(String userAnswer) {
        markCheckBoxSelection(question2a_correct, userAnswer, "1");
        markCheckBoxSelection(question2b_correct, userAnswer, "2");
        markCheckBoxSelection(question2c_correct, userAnswer, "3");
        markCheckBoxSelection(question2d_correct, userAnswer, "4");
    }

}