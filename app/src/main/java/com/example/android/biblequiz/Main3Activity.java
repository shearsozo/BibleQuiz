package com.example.android.biblequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class Main3Activity extends AppCompatActivity {
    /**
     * Variable to hold the amount of correct answers.
     */
    int correct = 0;

    CheckBox q2a_correct;
    CheckBox q2b_correct;
    CheckBox q2c_correct;
    CheckBox q2d_correct;

    /**
     * Method to navigate to next activity page when button is click.
     */
    public Button next2;
    public void gotopage(){
        next2= (Button)findViewById(R.id.next2);
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agape = new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(agape);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        gotopage();
    }
    /**
     * Method to record correct answer for question 2.
     * All answers are correct
     */
    public void questionTwo() {
        CheckBox q2a_correct = findViewById (R.id.checkanswer2a);
        CheckBox q2b_correct = findViewById (R.id.checkanswer2b);
        CheckBox q2c_correct = findViewById (R.id.checkanswer2c);
        CheckBox q2d_correct = findViewById (R.id.checkanswer2d);

        if (q2a_correct.isChecked() && q2b_correct.isChecked() && q2c_correct.isChecked() && q2d_correct.isChecked()) {
            correct++;
        }
    }

}
