package com.sankar.SRM144DIV2;

public class Time {

    public String whatTime(int seconds) {
        int h = seconds / 3600;
        seconds -= (3600 * h);
        int m = seconds / 60;
        seconds -= (60 * m);
        int s = seconds;

        return "" + h + ":" + m + ":" + s;
    }

}
