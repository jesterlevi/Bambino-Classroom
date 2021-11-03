package com.example.bambinoclassroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.view.View.OnClickListener;

public class Categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        ImageButton btn_ani = (ImageButton) findViewById(R.id.animals);
        ImageButton btn_col = (ImageButton) findViewById(R.id.colors);
        ImageButton btn_fru = (ImageButton) findViewById(R.id.fruits);
        ImageButton btn_sha = (ImageButton) findViewById(R.id.shapes);
        ImageButton btn_sou = (ImageButton) findViewById(R.id.sounds);
        ImageButton btn_veg = (ImageButton) findViewById(R.id.vegetables);

        btn_ani.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            openAnimals();
        }});

        btn_col.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openColors();
            }});

        btn_fru.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openFruits();
            }});

        btn_sha.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openShapes();
            }});

        btn_sou.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openSounds();
            }});

        btn_veg.setOnClickListener(new OnClickListener() {
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