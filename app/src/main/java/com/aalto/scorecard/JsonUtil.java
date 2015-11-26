package com.aalto.scorecard;

import android.content.Context;
import android.os.Environment;
import android.util.Log;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class JsonUtil {


    public static boolean toJson(Game game, Context ctx) {


        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm_dd-MM-yyyy");
        Date date = new Date();


        String fileName =  "SC_" + game.getCourse() + "_" + dateFormat.format(date) +".json";

        try {
            JSONObject jsonObj = new JSONObject();

            jsonObj.put("Course", game.getCourse());
            List<String> tList = game.getThrowList();
            List<String> pList = game.getParList();

            JSONArray jsonArr = new JSONArray();

            for (int i = 0; i < game.getNumOfHoles(); i++) {
                JSONObject thObject = new JSONObject();
                thObject.put("holeNum", i + 1);
                thObject.put("Par", pList.get(i));
                thObject.put("numOfThrows", tList.get(i));
                jsonArr.put(thObject);
            }

            jsonObj.put("holes", jsonArr);

            System.out.println(jsonObj);

            try {

           //     FileWriter file = new FileWriter(fileName);
           //     file.write(jsonObj.toString());

                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(ctx.openFileOutput(fileName, Context.MODE_PRIVATE));
                outputStreamWriter.write(jsonObj.toString());
                outputStreamWriter.close();


            }catch (IOException e) {
                e.printStackTrace();
            }


            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static String readJson(String fileName, Context ctx)
    {

        String ret = "";

        try {
            InputStream inputStream = ctx.openFileInput(fileName);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        ret = parseJson(ret);

        return ret;
    }

    private static String parseJson (String jString)
    {
        String res = "";

        try {
            JSONObject mainObject = new JSONObject(jString);
            JSONObject holeObject = mainObject.getJSONObject("holes");

            res += holeObject.getString("course") + "\n";

            for(int i = 0 ; i < holeObject.length(); i++ )
            {
                res += "hole " + holeObject.getString("holeNum") + "\n" +
                        "Par: " + holeObject.getString("par")  + "\n" +
                        "Throws: " + holeObject.getString("numOfThrows");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.print(res);

        return res;
    }
}
