package com.example.bambinoclassroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.bambinoclassroom.databinding.ActivityCategoriesBinding;

public class Categories extends AppCompatActivity {

    private ActivityCategoriesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.animals.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            openAnimals();
        }});

        binding.colors.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openColors();
            }});

        binding.fruits.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openFruits();
            }});

        binding.shapes.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openShapes();
            }});

        binding.sounds.setOnClickListener(v -> {
            YoYo.with(Techniques.Tada)
                    .duration(200)
                    .playOn(v);
            openSounds();
        });

        binding.vegetables.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openVegetables();
            }});
}
    public void openAnimals() {

        startActivity(GuessThePictureActivity.createIntent(this, "ANIMALS"));
    }

    public void openColors() {

        startActivity(GuessThePictureActivity.createIntent(this, "COLORS"));
    }

    public void openFruits() {

        startActivity(GuessThePictureActivity.createIntent(this, "FRUITS"));
    }

    public void openShapes() {

        startActivity(GuessThePictureActivity.createIntent(this, "SHAPES"));
    }

    public void openSounds() {
        Intent intent = new Intent(this, GuessTheSoundActivity.class);
        startActivity(intent);
    }

    public void openVegetables() {

        startActivity(GuessThePictureActivity.createIntent(this, "VEGETABLES"));
    }

}