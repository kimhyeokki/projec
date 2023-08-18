package com.javalecture.quiz;
class Mypoint{
    int x;
    int y;

    public Mypoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    double getDistance(int x1, int y1){
        int xsub = x1-x;
        int ysub = y1-y;
        double distance =Math.sqrt((xsub*xsub)+(ysub*ysub));
        return distance;
    }
  
}

public class Exercise6_6 {
    public static void main(String[] args) {
        Mypoint p =new Mypoint(1, 1);
        System.out.println(p.getDistance(2, 2));
    }
}
