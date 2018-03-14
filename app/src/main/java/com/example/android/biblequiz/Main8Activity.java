package com.example.android.biblequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Main8Activity extends AppCompatActivity {
    /**
     * Variable to hold the amount of correct answers.
     */
    int correct = 0;

    RadioButton q7_correct;
    /**
     * Method to navigate to next activity page when button is click.
     */
    public Button next7;
    public void gotopage(){
        next7= (Button)findViewById(R.id.next7);
        next7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agape = new Intent(Main8Activity.this,Main9Activity.class);
                startActivity(agape);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
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
}
