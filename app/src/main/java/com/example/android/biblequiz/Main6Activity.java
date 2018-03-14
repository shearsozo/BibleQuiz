package com.example.android.biblequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
     * Method to navigate to next activity page when button is click.
     */
    public Button next5;
    public void gotopage(){
        next5= (Button)findViewById(R.id.next5);
        next5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agape = new Intent(Main6Activity.this,Main7Activity.class);
                startActivity(agape);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        gotopage();
    }
    /**
     * Method to record correct answer for question 5.
     * only checkanswer5c is incorrect
     */
    public void questionFive() {
        CheckBox q5a_correct = findViewById (R.id.checkanswer5a);
        CheckBox q5b_correct = findViewById (R.id.checkanswer5b);
        CheckBox q5c_correct = findViewById (R.id.checkanswer5c);
        CheckBox q5d_correct = findViewById (R.id.checkanswer5d);

        if (q5a_correct.isChecked() && q5b_correct.isChecked() && !q5c_correct.isChecked() && q5d_correct.isChecked()) {
            correct++;
        }
    }
}
