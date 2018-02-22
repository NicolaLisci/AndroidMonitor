package Models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by nicolalisci on 20/02/18.
 */

public class Stats implements Serializable{

    private String wb_name;
    private float tMAX;
    private float tMIN;
    private float tAVG;
    private float uMAX;
    private float uMIN;
    private float uAVG;


    public Stats()
    {
        this.wb_name=wb_name;
        this.tMAX=tMAX;
        this.tMIN=tMIN;
        this.tAVG=tAVG;
        this.uMAX=uMAX;
        this.uMIN=uMIN;
        this.uAVG=uAVG;

    }

    private ArrayList<Stats> statsArrayList;

    public String getWb_name() {
        return wb_name;
    }

    public void setWb_name(String wb_name) {
        this.wb_name = wb_name;
    }

    public float gettMAX() {
        return tMAX;
    }

    public void settMAX(float tMAX) {
        this.tMAX = tMAX;
    }

    public float gettMIN() {
        return tMIN;
    }

    public void settMIN(float tMIN) {
        this.tMIN = tMIN;
    }

    public float gettAVG() {
        return tAVG;
    }

    public void settAVG(float tAVG) {
        this.tAVG = tAVG;
    }

    public float getuMAX() {
        return uMAX;
    }

    public void setuMAX(float uMAX) {
        this.uMAX = uMAX;
    }

    public float getuMIN() {
        return uMIN;
    }

    public void setuMIN(float uMIN) {
        this.uMIN = uMIN;
    }

    public float getuAVG() {
        return uAVG;
    }

    public void setuAVG(float uAVG) {
        this.uAVG = uAVG;
    }
}