package com.aalto.scorecard;




import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        int numHoles = 0;

        Intent intent = getIntent();
        String courseName = intent.getStringExtra(NewCourseActivity.EXTRA_COURSENAME);
        String StrHoles = intent.getStringExtra(NewCourseActivity.EXTRA_HOLES);
        try {
            numHoles = Integer.parseInt(StrHoles);
        } catch (NumberFormatException nfe) {
            System.out.println("Could not parse: " + nfe);
        }

        TextView textView = (TextView) findViewById(R.id.showName);
        textView.setText(courseName);


        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = new FragmentGame();
        FragmentTransaction ft = fm.beginTransaction();

        for (int i = 1; i < numHoles; i++){
            Log.i("fragment: ", "i: " + i );
            ft.add(R.id.holes, new FragmentGame(), "i_" + i);
        }
        ft.commit();



    }
}
