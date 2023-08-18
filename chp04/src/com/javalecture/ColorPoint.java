package com.javalecture;

public class ColorPoint extends Point {
    private String color;

    ColorPoint(int x, int y, String color){
        super(x, y);                                //부모클래스에서 생성자 함수 호출, super는 항상 첫줄에 작성해야 함
        this.color = color;
    }
    void showColorPoint(){
        System.out.println(color);
        showPoint();
    }
  
}
