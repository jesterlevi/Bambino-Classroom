package com.example.bambinoclassroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.bambinoclassroom.databinding.ActivityGuessThePictureBinding;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GuessTheSoundActivity extends AppCompatActivity {


    private List<QuestionItem> questionItems;
    private int currentQuestion = 0;

    private int correct = 0;
    private int wrong = 0;
    private ActivityGuessThePictureBinding binding;
    private String type;
    public final static String EXTRA_TYPE = "EXTRA_TYPE";

    public static Intent createIntent(Context context, String type) {
        Intent intent = new Intent(context, GuessThePictureActivity.class);
        intent.putExtra(EXTRA_TYPE, type);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGuessThePictureBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupExtras();


        //get all the questions
        loadAllQuestions();
        //shuffle the questions if you want
        Collections.shuffle(questionItems);
        //load first question
        setQuestionScreen(currentQuestion);

        binding.answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if the answer is correct
                if (questionItems.get(currentQuestion).getAnswer1()
                        .equals(questionItems.get(currentQuestion).getCorrect())) {
                    //correct
                    correct++;
                    Toast.makeText(GuessTheSoundActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    //wrong
                    wrong++;
                    Toast.makeText(GuessTheSoundActivity.this, "Wrong! Correct answer: "
                            + questionItems.get(currentQuestion).getCorrect(), Toast.LENGTH_SHORT).show();
                }

                //load next question if any
                if (currentQuestion < questionItems.size() - 1) {
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    //game over
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });

        binding.answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if the answer is correct
                if (questionItems.get(currentQuestion).getAnswer2()
                        .equals(questionItems.get(currentQuestion).getCorrect())) {
                    //correct
                    correct++;
                    Toast.makeText(GuessTheSoundActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    //wrong
                    wrong++;
                    Toast.makeText(GuessTheSoundActivity.this, "Wrong! Correct answer: "
                            + questionItems.get(currentQuestion).getCorrect(), Toast.LENGTH_SHORT).show();
                }

                //load next question if any
                if (currentQuestion < questionItems.size() - 1) {
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    //game over
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });

        binding.answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if the answer is correct
                if (questionItems.get(currentQuestion).getAnswer3()
                        .equals(questionItems.get(currentQuestion).getCorrect())) {
                    //correct
                    correct++;
                    Toast.makeText(GuessTheSoundActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    //wrong
                    wrong++;
                    Toast.makeText(GuessTheSoundActivity.this, "Wrong! Correct answer: "
                            + questionItems.get(currentQuestion).getCorrect(), Toast.LENGTH_SHORT).show();
                }

                //load next question if any
                if (currentQuestion < questionItems.size() - 1) {
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    //game over
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });

        binding.answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if the answer is correct
                if (questionItems.get(currentQuestion).getAnswer4()
                        .equals(questionItems.get(currentQuestion).getCorrect())) {
                    //correct
                    correct++;
                    Toast.makeText(GuessTheSoundActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    //wrong
                    wrong++;
                    Toast.makeText(GuessTheSoundActivity.this, "Wrong! Correct answer: "
                            + questionItems.get(currentQuestion).getCorrect(), Toast.LENGTH_SHORT).show();
                }

                //load next question if any
                if (currentQuestion < questionItems.size() - 1) {
                    currentQuestion++;
                    setQuestionScreen(currentQuestion);
                } else {
                    //game over
                    Intent intent = new Intent(getApplicationContext(), EndActivity.class);
                    intent.putExtra("correct", correct);
                    intent.putExtra("wrong", wrong);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void setupExtras() {
        if (getIntent().hasExtra(EXTRA_TYPE)) {
            type = getIntent().getStringExtra(EXTRA_TYPE);
        }
    }

    //set question to the screen
    private void setQuestionScreen(int number) {
        try {
            InputStream ims = getAssets().open(questionItems.get(number).getQuestion());
            Drawable drawable = Drawable.createFromStream(ims, null);
            Glide.with(this)
                    .load(drawable)
                    .into(binding.question);

            ims.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        binding.answer1.setText(questionItems.get(number).getAnswer1());
        binding.answer2.setText(questionItems.get(number).getAnswer2());
        binding.answer3.setText(questionItems.get(number).getAnswer3());
        binding.answer4.setText(questionItems.get(number).getAnswer4());
    }

    //make list with all the questions
    private void loadAllQuestions() {
        questionItems = new ArrayList<>();

        //load all questions into json string
        String questionnaireFilepath = "guess_the_sound.json";

        String jsonStr = loadJSONFromAsset(questionnaireFilepath);
        //load all data into the list
        Questionnaire questionnaire = new Gson().fromJson(jsonStr,Questionnaire.class);
        questionItems = questionnaire.getQuestions();

    }

    //load the json file from assets folder
    private String loadJSONFromAsset(String file) {
        String json = "";
        try {
            InputStream is = getAssets().open(file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e){
            e.printStackTrace();
        }
        return json;
    }
}