package com.aalto.scorecard;


import java.util.ArrayList;
import java.util.List;

public class Game {

    private String  course;
    private int     numOfHoles;
    private List<String> throwList = new ArrayList<String>();
    private  List<String> parList = new ArrayList<String>();

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getNumOfHoles() {
        return numOfHoles;
    }

    public void setNumOfHoles(int numOfHoles) {
        this.numOfHoles = numOfHoles;
    }

    public List<String> getThrowList() {
        return throwList;
    }

    public void addThrowList(String thr) {
        throwList.add(thr);
    }
    public void addParList(String par) {
        parList.add(par);
    }

    public List<String> getParList() {
        return parList;
    }
}
