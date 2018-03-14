package com.example.android.biblequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Main4Activity extends AppCompatActivity {
    /**
     * Variable to hold the amount of correct answers.
     */
    int correct = 0;

    RadioButton q3_correct;
    /**
     * Method to navigate to next activity page when button is click.
     */
    public Button next3;
    public void gotopage(){
        next3= (Button)findViewById(R.id.next3);
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agape = new Intent(Main4Activity.this,Main5Activity.class);
                startActivity(agape);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        gotopage();
    }
    /**
     * Method to record correct answer for question 3.
     */
    public void questionThree() {
        RadioButton q3_correct = findViewById (R.id.answer3);

        if (q3_correct.isChecked ()) {
            correct++;
        }
    }
}
