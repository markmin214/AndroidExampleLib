package com.example.myapplication;

/**
 * Created by markmin on 16/6/12.
 */
public class Question {

    int id;
    String qustionDes;
    String trueAnswer;


    public Question(int id, String qustionDes, String trueAnswer) {
        this.id = id;
        this.qustionDes = qustionDes;
        this.trueAnswer = trueAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQustionDes() {
        return qustionDes;
    }

    public void setQustionDes(String qustionDes) {
        this.qustionDes = qustionDes;
    }

    public String getTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(String trueAnswer) {
        this.trueAnswer = trueAnswer;
    }
}
