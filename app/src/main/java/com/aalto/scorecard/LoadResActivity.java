package com.aalto.scorecard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import static com.aalto.scorecard.JsonUtil.readJson;

public class LoadResActivity extends Activity {

    public final static String EXTRA_JSONDATA = "com.aalto.scorecard.EXTRA_FILENAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_res);
        ListView listSavedFiles = (ListView)findViewById(R.id.list);

        String[] SavedFiles = getApplicationContext().fileList();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,SavedFiles);

        listSavedFiles.setAdapter(adapter);

        listSavedFiles.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Context context = getApplicationContext();
                String item = ((TextView)view).getText().toString();
                String res = readJson(item, context);

                Intent intent = new Intent(view.getContext(), ShowJsonActivity.class);
                intent.putExtra(EXTRA_JSONDATA, res);
                startActivity(intent);


                //Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT ).show();
            }
        });

    }
}
