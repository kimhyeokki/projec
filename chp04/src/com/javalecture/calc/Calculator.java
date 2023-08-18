package com.javalecture.calc;

public abstract class Calculator{                 //추상 클래스 // 설계와 구현의 구분을 위해
    public abstract int add(int a, int b);        //추상 메서드
    public abstract int subtract(int a, int b);   //추상 메서드
    
    public abstract double avg(int [] array);   //추상 메서드

}
class SamsungCalculator extends Calculator{

    @Override
    public int add(int a, int b) {
       return a+b;
    }

    @Override
    public int subtract(int a, int b) {
        return a>b? a-b : b-a;
    }

    @Override
    public double avg(int[] array) {
        double sum=0;
        for(int i =0; i<array.length;i++){
            sum += array[i];
        }
        return sum/array.length;
    }
    public static void main(String[] args) {
        SamsungCalculator sc =new SamsungCalculator();
        sc.add(32, 45);
        sc.subtract(54, 55);
        int array[] ={4,5,9};
        sc.avg(array);
        System.out.println(sc.avg(array));
    }

}
class LgCalculator extends Calculator{

    @Override
    public int add(int a, int b) {
       return a+b;
    }

    @Override
    public int subtract(int a, int b) {
        return 0;
    }

    @Override
    public double avg(int[] array) {
       return 0;
    }

}
