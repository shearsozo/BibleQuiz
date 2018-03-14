package com.example.android.biblequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main5Activity extends AppCompatActivity {
    EditText q4_correct;
    String user_answer4;
    /**
     * Method to navigate to next activity page when button is click.
     */
    public Button next4;
    public void gotopage(){
        next4= (Button)findViewById(R.id.next4);
        next4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agape = new Intent(Main5Activity.this,Main6Activity.class);
                startActivity(agape);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        gotopage();
    }
    /**
     * Method to record correct answer for question 4.
     */
    public void questionFour() {
        EditText q4_correct = findViewById(R.id.answer4);
        String user_answer4 = q4_correct.getText().toString();

        if (user_answer4.equals("God")) {

        }
    }
}
