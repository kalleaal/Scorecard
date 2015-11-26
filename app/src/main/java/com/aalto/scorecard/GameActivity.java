package com.aalto.scorecard;




import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import static com.aalto.scorecard.JsonUtil.toJson;

public class GameActivity extends FragmentActivity {

    String courseName;
    int numHoles = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        courseName = intent.getStringExtra(NewCourseActivity.EXTRA_COURSENAME);
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
            ft.add(R.id.holes, new FragmentGame(), "frag_" + i);
        }
        ft.commit();


    }
    public void onGameDone(View view) {

        Game gameObject = new Game();
        gameObject.setCourse(courseName);
        gameObject.setNumOfHoles(numHoles);

        for (int i = 0; i< numHoles; i++) {
            FragmentGame frag = (FragmentGame) getSupportFragmentManager().findFragmentByTag("frag_" + i);
           // System.out.println("--LOG-- par: " + frag.getPar() );
           // System.out.println("--LOG-- throwNum: " + frag.getThrowNum() );
            gameObject.addParList(frag.getPar());
            gameObject.addThrowList(frag.getThrowNum());
        }

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        CharSequence toastText = "";

        if (toJson(gameObject, context)) {
           toastText = "JSON succsessful";

        }
        else {
           toastText = "JSON NOT successful";
        }
        Toast toast = Toast.makeText(context, toastText, duration);
        toast.show();
    }
}
