package com.galleryapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;

public class DetailActivity extends AppCompatActivity {

    private MyTts myTts;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detail), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        myTts = new MyTts(this);

        Intent intent = getIntent();
        String paintingJson = intent.getStringExtra("painting");
        Painting painting = new Gson().fromJson(paintingJson, Painting.class);

        ImageView paintingImage = findViewById(R.id.painting_image);
        TextView paintingTitle = findViewById(R.id.painting_title);
        TextView paintingArtistYear = findViewById(R.id.painting_artist_year);
        TextView paintingDescription = findViewById(R.id.painting_description);
        Button speakButton = findViewById(R.id.speak_button);

        assert painting != null;
        paintingImage.setImageResource(painting.getImageResource());
        paintingTitle.setText(painting.getTitle());
        paintingArtistYear.setText(painting.getArtist() + ", " + painting.getYear());
        paintingDescription.setText(painting.getDescription());

        speakButton.setOnClickListener(v -> {
            String text = painting.getTitle() + " by " + painting.getArtist() + ", " + painting.getYear() + ". " + painting.getDescription();
            myTts.speak(text);
        });
    }

    public void close(View view) {
        if (myTts != null) {
            myTts.shutdown();
        }
        finish();
    }
}