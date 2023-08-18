package com.javalecture;

public class Point{
    private int x,y;
    
    public Point() {
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
   
    public void showPoint(){
         System.out.printf("(%d),(%d)",x,y);
    }
    

}