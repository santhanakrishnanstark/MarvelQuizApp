package com.example.stark.marvelquizapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class QuizPage extends AppCompatActivity {

    Button btntrue,btnfalse;
    TextView questionview,scoretxt;
    int index,score;
    ProgressBar progress;


    TrueFalse questionbank[]=new TrueFalse[]{
            new TrueFalse(R.string.question_1,false),
            new TrueFalse(R.string.question_2,false),
            new TrueFalse(R.string.question_3,true),
            new TrueFalse(R.string.question_4,false),
            new TrueFalse(R.string.question_5,true),
            new TrueFalse(R.string.question_6,true),
            new TrueFalse(R.string.question_7,false),
            new TrueFalse(R.string.question_8,false),
            new TrueFalse(R.string.question_9,true),
            new TrueFalse(R.string.question_10,true)
    };

    final int progressbarinc=(int) Math.ceil(100/questionbank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);

        btntrue = findViewById(R.id.btntrue);
        btnfalse = findViewById(R.id.btnfalse);
        questionview = findViewById(R.id.questions);
        scoretxt = findViewById(R.id.scoretxt);
        progress = findViewById(R.id.progress);


        questionview.setText(questionbank[index].getQuestionId());


        btntrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(questionbank[index].isAnswer()){
                    Toast.makeText(getApplicationContext(),"Right Ans",Toast.LENGTH_SHORT).show();
                    score++;
                }else
                {
                    Toast.makeText(getApplicationContext(),"Wrong Ans",Toast.LENGTH_SHORT).show();
                }
                updateQuestions();
                //Toast.makeText(getApplicationContext(),"Clicked True",Toast.LENGTH_SHORT).show();
            }
        });

        btnfalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!questionbank[index].isAnswer()){
                    Toast.makeText(getApplicationContext(),"Right Ans",Toast.LENGTH_SHORT).show();
                    score++;
                }else
                {
                    Toast.makeText(getApplicationContext(),"Wrong Ans",Toast.LENGTH_SHORT).show();
                }
                updateQuestions();
                //Toast.makeText(getApplicationContext(),"Clicked False",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void updateQuestions() {
        index=(index+1)%questionbank.length;
        if (index==0){
            AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
            alert.setTitle("Quiz Over");
            alert.setCancelable(false);
            alert.setMessage("You Scored "+score+"points");
            alert.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            alert.show();
        }
        questionview.setText(questionbank[index].getQuestionId());
        scoretxt.setText("Score : "+score+"/"+questionbank.length);
        progress.incrementProgressBy(progressbarinc);
    }
}
