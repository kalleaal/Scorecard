package com.aalto.scorecard;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JsonUtil {

    public static String toJson(Game game) {
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

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
