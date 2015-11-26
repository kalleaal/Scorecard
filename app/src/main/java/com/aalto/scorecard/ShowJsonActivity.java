package com.aalto.scorecard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShowJsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_json);

        TextView textField = (TextView)findViewById(R.id.jsonText);

        Intent intent = getIntent();
        String JSON = intent.getStringExtra(LoadResActivity.EXTRA_JSONDATA);

        textField.setText(JSON);

    }
}
