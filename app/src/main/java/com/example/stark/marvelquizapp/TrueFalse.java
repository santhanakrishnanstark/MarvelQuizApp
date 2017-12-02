package com.example.stark.marvelquizapp;

/**
 * Created by Stark on 12/1/2017.
 */

public class TrueFalse {

    private int questionId;
    private boolean answer;

    public TrueFalse(int questionResourceId,boolean trueorfalse){
        questionId = questionResourceId;
        answer = trueorfalse;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
