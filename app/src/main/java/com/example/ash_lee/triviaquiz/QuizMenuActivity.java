package com.example.ash_lee.triviaquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class QuizMenuActivity extends QuizActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);

        //Play the game, review the help, configure the settings, view the high scores

        //could have a bunch of buttons and listen for clicks -
        //but this will NOT scale well! SO - List view!

        ListView menuList = (ListView) findViewById(R.id.ListView_Menu);

        String[] items = { getResources().getString(R.string.menu1),
                getResources().getString(R.string.menu2),
                getResources().getString(R.string.menu3),
                getResources().getString(R.string.menu4)};

        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, R.layout.menu_item, items);
        //tell the ListView to use the adapter

        menuList.setAdapter(adapt);

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                TextView textView = (TextView) itemClicked;
                String strText = textView.getText().toString();
                //if strTest = name of menu item string, launch that activity
                if (strText.equalsIgnoreCase(getResources().getString(R.string.menu1))){
                    startActivity(new Intent(QuizMenuActivity.this, QuizGameActivity.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu2))){
                    startActivity(new Intent(QuizMenuActivity.this, QuizScoresActivity.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu3))){
                    startActivity(new Intent(QuizMenuActivity.this, QuizSettingsActivity.class));
                } else if (strText.equalsIgnoreCase(getResources().getString(R.string.menu4))){
                    startActivity(new Intent(QuizMenuActivity.this, QuizHelpActivity.class));
                }

            }
        });


    }
}
