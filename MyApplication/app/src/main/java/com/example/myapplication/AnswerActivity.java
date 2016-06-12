package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnswerActivity extends Activity {


    public static final String QUESTION_ANSWER = "question_id";
    public static final String HAVE_VIEW_ANSWER = "have look at answer";

    TextView showAnswer;
    String answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_main);

         answer = getIntent().getStringExtra(QUESTION_ANSWER);

         showAnswer = (TextView) findViewById(R.id.tv_answer_show);


        Button btnView = (Button) findViewById(R.id.bt_view_answer);
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAnswer.setText(answer);
                Intent data = new Intent();
                data.putExtra(HAVE_VIEW_ANSWER,true);
                setResult(RESULT_OK,data);
            }
        });

    }


}
