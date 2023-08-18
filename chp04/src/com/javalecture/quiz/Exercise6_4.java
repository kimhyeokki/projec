package com.javalecture.quiz;

public class Exercise6_4 {
    static double getDistance(int x, int y, int x1, int y1){
        int xsub = x1-x;
        int ysub = y1-y;
        double distance =Math.sqrt((xsub*xsub)+(ysub*ysub));
        return distance;
    }
    public static void main(String[] args) {
        System.out.println(getDistance(1, 1, 2, 2));
    }
}
