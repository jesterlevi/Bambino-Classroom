package com.example.bambinoclassroom.model;


import android.media.Image;

import com.google.gson.annotations.SerializedName;

public class QuestionItem {

    @SerializedName("answer1")

    private String answer1;

    @SerializedName("answer2")
    private String answer2;

    @SerializedName("answer3")
    private String answer3;

    @SerializedName("answer4")
    private String answer4;

    @SerializedName("correct")
    private String correct;

    @SerializedName("question")
    private String question;

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public String getCorrect() {
        return correct;
    }

    public String getQuestion() {
        return question;

    }

    public QuestionItem(String answer1, String answer2, String answer3, String answer4, String correct, String question) {
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correct = correct;
        this.question = question;
    }
}
