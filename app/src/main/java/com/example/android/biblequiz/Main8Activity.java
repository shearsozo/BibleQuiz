package com.example.android.biblequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Main8Activity extends AppCompatActivity {
    /**
     * Variable to hold the amount of correct answers.
     */
    int correct = 0;
    RadioButton q7_correct;
    RadioGroup q7_rGroup;
    /**
     * Declare placeholder for user answer
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
    public Button next7;
    public Button previous7;
    public void gotopage(){
        next7= (Button)findViewById(R.id.next7);
        previous7= (Button)findViewById(R.id.previous7);
        next7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get the index of the checked radio group and cast to string
                answer7 = String.valueOf(getRadioButtonSelection(q7_rGroup));
                Intent agape = new Intent(Main8Activity.this,Main9Activity.class);
                dressUpIntent(agape);
            }
        });
        previous7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer7 = String.valueOf(getRadioButtonSelection(q7_rGroup));
                Intent agape = new Intent(Main8Activity.this,Main7Activity.class);
                dressUpIntent(agape);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        q7_rGroup = findViewById(R.id.rgAnswer7);
        loadAnswerFromMyIntend();
        /*
        If answer7 has some answer, then preselect.

         */
        if(answer7 != null){
            int intAnswer1 = Integer.parseInt(answer7);
            setRadioButtonByIndex(q7_rGroup, intAnswer1);
        }
        gotopage();
    }
    /**
     * Method to record correct answer for question 7.
     */
    public void questionSeven() {
        RadioButton q7_correct = findViewById (R.id.answer7);

        if (q7_correct.isChecked ()) {
            correct++;
        }
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
}
