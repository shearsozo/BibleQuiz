package com.example.android.biblequiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Main9Activity extends AppCompatActivity {
    /**
     * Variable to hold the amount of correct answers.
     */
    int correct = 0;
    RadioButton q1_correct;
    RadioGroup q1_rGroup;

    CheckBox q2a_correct;
    CheckBox q2b_correct;
    CheckBox q2c_correct;
    CheckBox q2d_correct;

    RadioButton q3_correct;
    RadioGroup q3_rGroup;

    String user_answer4;
    EditText q4_correct;

    CheckBox q5a_correct;
    CheckBox q5b_correct;
    CheckBox q5c_correct;
    CheckBox q5d_correct;

    String user_answer6;
    EditText q6_correct;

    RadioButton q7_correct;
    RadioGroup q7_rGroup;


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
        if(answer1 != null){
            int intAnswer1 = Integer.parseInt(answer1);
            setRadioButtonByIndex(q1_rGroup, intAnswer1);
        }
        if(answer2 !=null) {
            reloadCheckBoxFromUserAnswer(answer2);
        }
        if(answer3 != null){
            int intAnswer1 = Integer.parseInt(answer3);
            setRadioButtonByIndex(q3_rGroup, intAnswer1);
        }
        if(answer4 !=null){
            q4_correct.setText(answer4);
        }
        if(answer5 !=null) {
            reloadCheckBoxFromUserAnswer(answer5);
        }
        if(answer6 !=null){
            q6_correct.setText(answer4);
        }
        if(answer7 != null){
            int intAnswer1 = Integer.parseInt(answer7);
            setRadioButtonByIndex(q7_rGroup, intAnswer1);
        }
        gotopage();
    }

    /**
     * Method to calculate all answers when checkscore button is click
     */
    public void result(View view){
        if (q1_correct.isChecked ()) {
            correct++;
        }
        if (q3_correct.isChecked ()) {
            correct++;
        }
        if (user_answer4.equalsIgnoreCase("God")) {
            correct++;
        }
        if (user_answer6.equalsIgnoreCase("world")) {
            correct++;
        }
        if (q7_correct.isChecked ()) {
            correct++;
        }
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
    /**
     Pass in the radio button group reference and return the index of the checked radio button
     This index will be used as the answer
     */
    public int getRadioButtonSelection(RadioGroup vMyRGroup){
        int index = vMyRGroup.indexOfChild(findViewById(vMyRGroup.getCheckedRadioButtonId()));
        return index;
    }
    /**
     * Pass in the radio button group reference as well as the index of the radio button to check and set it
     */
    public void setRadioButtonByIndex(RadioGroup vMyRGroup, int checkedIndex){
        ((RadioButton)vMyRGroup.getChildAt(checkedIndex)).setChecked(true);
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
        if (q2a_correct.isChecked())
            q2Answer = "1";
        q2Answer = q2Answer + "|";
        if (q2b_correct.isChecked())
            q2Answer = q2Answer + "2";
        if (q2c_correct.isChecked())
            q2Answer = q2Answer + "3";
        q2Answer = q2Answer + "|";
        if (q2d_correct.isChecked())
            q2Answer = q2Answer + "4";
        return q2Answer;


        String q5Answer = "";
        if (q5a_correct.isChecked())
            q5Answer = "1";
        q5Answer = q5Answer + "|";
        if (q5b_correct.isChecked())
            q5Answer = q5Answer + "2";
        if (q5c_correct.isChecked())
            q5Answer = q5Answer + "3";
        q5Answer = q5Answer + "|";
        if (q5d_correct.isChecked())
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
        markCheckBoxSelection(q2a_correct, userAnswer, "1" );
        markCheckBoxSelection(q2b_correct, userAnswer, "2" );
        markCheckBoxSelection(q2c_correct, userAnswer, "3" );
        markCheckBoxSelection(q2d_correct, userAnswer, "4" );
        markCheckBoxSelection(q5a_correct, userAnswer, "1" );
        markCheckBoxSelection(q5b_correct, userAnswer, "2" );
        markCheckBoxSelection(q5c_correct, userAnswer, "3" );
        markCheckBoxSelection(q5d_correct, userAnswer, "4" );
    }
    /**
     * reload answers from intent
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


}
