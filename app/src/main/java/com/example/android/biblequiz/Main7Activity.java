package com.example.android.biblequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main7Activity extends AppCompatActivity {
    /**
     * Method to navigate to next activity page when button is click.
     */
    public Button next6;
    public void gotopage(){
        next6= (Button)findViewById(R.id.next6);
        next6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agape = new Intent(Main7Activity.this,Main8Activity.class);
                startActivity(agape);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        gotopage();
    }
    /**
     * Method to record correct answer for question 6.
     */
    public void questionSix() {
        EditText q6_correct = findViewById(R.id.answer4);
        String user_answer6 = q6_correct.getText().toString();

        if (user_answer6.equals("world")) {

        }
    }
}
