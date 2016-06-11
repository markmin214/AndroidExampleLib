package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {


    private TextView wordQuestion;
    private TextView wordAnswer1;
    private TextView wordAnswer2;
    private TextView wordAnswer3;
    private TextView wordAnswer4;
    private Button pre;
    private Button viewAnswer;
    private Button nextQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {


        wordQuestion = (TextView) findViewById(R.id.word_question);
        wordAnswer1 = (TextView) findViewById(R.id.word_answer1);
        wordAnswer2 = (TextView) findViewById(R.id.word_answer2);
        wordAnswer3 = (TextView) findViewById(R.id.word_answer3);
        wordAnswer4 = (TextView) findViewById(R.id.word_answer4);
        pre = (Button) findViewById(R.id.pre);
        viewAnswer = (Button) findViewById(R.id.view_answer);
         viewAnswer.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getApplicationContext(),AnswerActivity.class);

                 startActivity(intent);
             }
         });
        nextQuestion = (Button) findViewById(R.id.next_question);

    }
}
