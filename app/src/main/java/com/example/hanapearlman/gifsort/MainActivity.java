package com.example.hanapearlman.gifsort;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.Glide;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btStart = (Button) findViewById(R.id.btStart);

        Glide.with(this)
                .load("https://media.giphy.com/media/l1J9zN4nEzGVzFeFi/giphy.gif")
                .asGif()
                .preload();

        Glide.with(this)
                .load("https://media.giphy.com/media/3ov9jSWpg7q8kNgB1u/giphy.gif")
                .asGif()
                .preload();

        Glide.with(this)
                .load("https://media.giphy.com/media/26n7brVD4CvQiFmr6/giphy.gif")
                .asGif()
                .preload();

        Glide.with(this)
                .load("https://media.giphy.com/media/J6ctgPvnDpDi0/giphy.gif")
                .asGif()
                .preload();

        Glide.with(this)
                .load("https://media.giphy.com/media/xT1Ra13p4KSoAJfxQc/giphy.gif")
                .asGif()
                .preload();

        Glide.with(this)
                .load("https://media.giphy.com/media/c9IhvdUkamYtq/giphy.gif")
                .asGif()
                .preload();

        Glide.with(this)
                .load("https://media.giphy.com/media/qzL91Fy1mtJVC/giphy.gif")
                .asGif()
                .preload();

    }

    public void goToGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
