package com.example.ash_lee.triviaquiz;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QuizActivity extends AppCompatActivity {

    public static final String GAME_PREFERENCES = "GamePrefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        SharedPreferences settings = getSharedPreferences(GAME_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString("UserName", "JaneDoe");
        prefEditor.putInt("UserAge", 22);
        prefEditor.commit();

        //clear prefs with prefEditor.clear();

        //retrieving sharedPrefs
        if (settings.contains("UserName") == true){
            //We have a username
            String user = settings.getString("UserName", "Default");
        }
    }
}
