package com.aalto.scorecard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class NewCourseActivity extends AppCompatActivity {

    public final static String EXTRA_COURSENAME = "com.aalto.scorecard.COURSENAME";
    public final static String EXTRA_HOLES = "com.aalto.scorecard.HOLES";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_course);

    }
    public void startGameActivity(View view){
        EditText courseName = (EditText) findViewById(R.id.courseName);
        EditText numOfHoles = (EditText) findViewById(R.id.holes);
        String name = courseName.getText().toString();
        String holes = numOfHoles.getText().toString();

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra(EXTRA_COURSENAME, name);
        intent.putExtra(EXTRA_HOLES, holes);
        startActivity(intent);


    }

}
