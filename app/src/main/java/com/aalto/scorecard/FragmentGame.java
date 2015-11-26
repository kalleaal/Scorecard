package com.aalto.scorecard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class FragmentGame extends Fragment {

    private EditText par;
    private EditText throwNum;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.hole_fragment, container, false);

        par = (EditText) view.findViewById(R.id.par);
        throwNum = (EditText) view.findViewById(R.id.numOfThrows);

        return view;
    }

    public String getPar() {
        return par.getText().toString();
    }

    public String getThrowNum() {
        return throwNum.getText().toString();
    }
}