package com.example.hanapearlman.gifsort;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class GameActivity extends AppCompatActivity {

    private GestureDetectorCompat mDetector;
    private static final String DEBUG_TAG = "Gestures";
    CardView cvGif;
    private HashMap<String, TreeSet<String>> categories = new HashMap<>();
    ImageView ivGif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mDetector = new GestureDetectorCompat(this, new MyGestureListener());

        cvGif = (CardView) findViewById(R.id.cvGif);
        ivGif = (ImageView) findViewById(R.id.ivGif);

        Glide.with(this)
                .load("https://media.giphy.com/media/RTvv8ST7rYUec/giphy.gif")
                .asGif()
                .into(ivGif);

        cvGif.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mDetector.onTouchEvent(motionEvent);
                return true;
            }
        });

        fillCategories();
    }

    private void fillCategories() {
        categories.put("Animals", new TreeSet<String>(Arrays.asList("cats", "dogs", "walrus",
                        "birds", "fish", "panda", "bunnies", "penguin", "horse", "pig",
                        "owl", "duck", "butterfly", "fox", "sloth", "giraffe")));
        categories.put("Motion", new TreeSet<String>(Arrays.asList("bounce", "jump", "run",
                        "sleep", "dance", "swim", "drink")));
        categories.put("Entertainment", new TreeSet<String>(Arrays.asList("disney", "glee",
                        "simpsons", "sponge bob", "hamilton", "anime")));
        categories.put("Emotions", new TreeSet<String>(Arrays.asList("cry", "smile", "happy",
                        "sad", "angry", "no", "yas", "heart")));
        categories.put("Nature", new TreeSet<String>(Arrays.asList("rain", "snow", "sun", "wind", "water",
                        "tornado", "fire", "flower", "sea", "space", "globe")));
        categories.put("Cute", new TreeSet<String>(Arrays.asList("babies", "dogs", "cats",
                        "bunnies", "boop", "love")));
        categories.put("Misc", new TreeSet<String>(Arrays.asList("hand", "kids", "math", "school",
                        "money", "clock", "beach", "workout", "ballet", "memes", "fireworks")));
        categories.put("Food", new TreeSet<String>(Arrays.asList("fries", "burgers", "ice cream",
                        "cake", "pizza", "cookie", "chocolate", "candy")));
        categories.put("Sports", new TreeSet<String>(Arrays.asList("soccer", "basketball",
                        "football", "frisbee", "golf", "baseball")));
        categories.put("People", new TreeSet<String>(Arrays.asList("obama", "trump", "hillary",
                        "beyonce", "bieber", "nicki", "lorde", "tswift", "kkw", "vader", "bart",
                         "homer", "patrick", "sponge bob", "jlaw", "gaga", "rihanna", "zayn",
                         "bernie")));
        categories.put("KPop", new TreeSet<String>(Arrays.asList("bts", "snsd", "blackpink",
                        "twice", "bigbang", "got7", "iu")));
        categories.put("Colors", new TreeSet<String>(Arrays.asList("red", "blue", "green",
                        "yellow", "orange")));
        categories.put("Trippy", new TreeSet<String>(Arrays.asList("fractal", "psychedelic",
                        "spiral", "recursion")));
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent event) {
            Log.d(DEBUG_TAG,"onDown: " + event.toString());
            return true;
        }

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            Log.d(DEBUG_TAG, "onFling: " + event1.toString() + event2.toString());
            float diffY = event2.getY() - event1.getY();
            float diffX = event2.getX() - event1.getX();
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (diffX > 0) {
                    onSwipeRight();
                } else {
                    onSwipeLeft();
                }
            }
            else {
                if (diffY > 0) {
                    onSwipeBottom();
                } else {
                    onSwipeTop();
                }
            }
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent event) {
            Log.d(DEBUG_TAG, "onDoubleTap: " + event.toString());
            return true;
        }
    }

    public void onSwipeRight() {
        //TODO: accelerate card right
        Animation animation = new TranslateAnimation(0, 900, 0, 0);
        animation.setDuration(200);
        animation.setFillAfter(false);
        //llTransportOptions.startAnimation(animation);
        cvGif.startAnimation(animation);
        Log.d(DEBUG_TAG, "onSwipeRight: ");
    }

    public void onSwipeLeft() {
        //TODO: accelerate card left
        Animation animation = new TranslateAnimation(0, -900, 0, 0);
        animation.setDuration(200);
        animation.setFillAfter(false);
        //llTransportOptions.startAnimation(animation);
        cvGif.startAnimation(animation);
        Log.d(DEBUG_TAG, "onSwipeLeft: ");
    }

    public void onSwipeTop() {
        //TODO: accelerate card top
        Animation animation = new TranslateAnimation(0, 0, 0, -1500);
        animation.setDuration(350);
        animation.setFillAfter(false);
        //llTransportOptions.startAnimation(animation);
        cvGif.startAnimation(animation);
        Log.d(DEBUG_TAG, "onSwipeTop: ");
    }

    public void onSwipeBottom() {
        //TODO: accelerate card bottom
        Animation animation = new TranslateAnimation(0, 0, 0, 1500);
        animation.setDuration(350);
        animation.setFillAfter(false);
        //llTransportOptions.startAnimation(animation);
        cvGif.startAnimation(animation);
        Log.d(DEBUG_TAG, "onSwipeDown: ");
    }

}
