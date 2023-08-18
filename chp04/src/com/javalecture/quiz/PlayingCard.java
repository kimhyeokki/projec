package com.javalecture.quiz;

public class PlayingCard {
    int kind;                   //인스턴스 변수
    int num;

    static int width;            //클래스 변수
    static int height;

    PlayingCard(int k, int n)    //지역변수
    {
        kind =k;
        num = n;
    }
    public static void main(String[] args) {
        PlayingCard card = new PlayingCard(1, 1);
    }
}
