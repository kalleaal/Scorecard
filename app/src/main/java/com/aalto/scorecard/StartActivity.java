package com.aalto.scorecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }
    public void startNew(View view)
    {
        Intent intent = new Intent(this, NewCourseActivity.class);
        startActivity(intent);
    }

    public void loadRes(View view)
    {
        Intent intent = new Intent(this, LoadResActivity.class);
        startActivity(intent);
    }

}
