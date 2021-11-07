package com.example.bambinoclassroom.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Questionnaire {
    @SerializedName("questions")
    private List<QuestionItem> questions = new ArrayList();

    public List<QuestionItem> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionItem> questions) {
        this.questions = questions;
    }
}

