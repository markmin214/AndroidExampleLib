package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {


    List<Question>  questions;
    Question curQuestion ;
    boolean isViewAnswer = false;
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

        initdata();
        curQuestion = questions.get(1);
         initView();

    }

    private void initdata() {
        questions =new ArrayList<>();
        questions.add(new Question(1,"android","open source OS"));
        questions.add(new Question(2,"ios","OS from Apple"));
        questions.add(new Question(3,"ios","iphone"));
        questions.add(new Question(4,"window","Microsoft"));

    }

    private void initView() {


        wordQuestion = (TextView) findViewById(R.id.word_question);
        wordAnswer1 = (TextView) findViewById(R.id.word_answer1);
        wordAnswer2 = (TextView) findViewById(R.id.word_answer2);
        wordAnswer3 = (TextView) findViewById(R.id.word_answer3);
        wordAnswer4 = (TextView) findViewById(R.id.word_answer4);
        pre = (Button) findViewById(R.id.pre);
        nextQuestion = (Button) findViewById(R.id.next_question);
        viewAnswer = (Button) findViewById(R.id.view_answer);


         viewAnswer.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(getApplicationContext(),AnswerActivity.class);
                 intent.putExtra(AnswerActivity.QUESTION_ANSWER,curQuestion.getTrueAnswer());
                 startActivityForResult(intent,0);
             }
         });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

         isViewAnswer = data.getBooleanExtra(AnswerActivity.HAVE_VIEW_ANSWER,false);
        Toast.makeText(this,"you have check answer",Toast.LENGTH_SHORT).show();

    }
}
