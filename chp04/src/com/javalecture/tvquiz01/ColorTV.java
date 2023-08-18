package com.javalecture.tvquiz01;

public class ColorTV extends Tv {
    private int nColor;

    public int getnColor() {
        return nColor;
    }

    ColorTV(int size, int nColor){
        super(size);
        this.nColor =nColor;
    }
  
    public void showInfo(){
        System.out.printf("%d인치에 %d인 Tv입니다.",getSize(), getnColor());
    }
    

    public static void main(String[] args) {
       Tv tv = new Tv(30);
       ColorTV colorTV = new ColorTV(30, 256);
       colorTV.showInfo();
    }
}
