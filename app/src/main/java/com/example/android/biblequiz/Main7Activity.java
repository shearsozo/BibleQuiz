package com.example.android.biblequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main7Activity extends AppCompatActivity {
    /**
     * Variable to hold the amount of correct answers.
     */
    int correct = 0;
    EditText q6_correct;
    String user_answer6;
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
     * Method to navigate to different activity page when button is click.
     */
    public Button next6;
    public Button previous6;
    public void gotopage(){
        next6= (Button)findViewById(R.id.next6);
        previous6= (Button)findViewById(R.id.previous6);
        next6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer6 = String.valueOf(user_answer6);
                Intent agape = new Intent(Main7Activity.this,Main8Activity.class);
                dressUpIntent(agape);
            }
        });
        previous6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                answer6 = String.valueOf(user_answer6);
                Intent agape = new Intent(Main7Activity.this,Main6Activity.class);
                dressUpIntent(agape);
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        q6_correct = findViewById(R.id.answer6);
        loadAnswerFromMyIntend();
        if(answer6 !=null)
            gotopage();
    }
    /**
     * Method to record correct answer for question 6.
     */
    public void questionSix() {
        EditText q6_correct = findViewById(R.id.answer6);
        String user_answer6 = q6_correct.getText().toString();

        if (user_answer6.equalsIgnoreCase("world")) {
        }
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
