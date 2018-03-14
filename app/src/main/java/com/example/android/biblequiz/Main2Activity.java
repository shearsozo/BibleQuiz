package com.example.android.biblequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Main2Activity extends AppCompatActivity {
    /**
     * Variable to hold the amount of correct answers.
     */
    int correct = 0;

    RadioButton q1_correct;

    /**
     * Method to navigate to next activity page when button is click.
     */
    public Button next1;
    public void gotopage(){
        next1= (Button)findViewById(R.id.next1);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agape = new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(agape);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        gotopage();
    }
    /**
     * Method to record correct answer for question 1.
     */
    public void questionOne() {
        RadioButton q1_correct = findViewById (R.id.answer1);

        if (q1_correct.isChecked ()) {
            correct++;
        }
    }
}
