package com.javalecture.quiz;

public class Student {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;
    

    int getTotal(){
        return kor+math+eng;
    }
    double getAverage(){
        return Math.ceil((getTotal()/3.0)*10)/10;
    }
    public static void main(String[] args) {
        Student s = new Student();
        s.name ="홍길동";
        s.ban = 1;
        s.no = 1;
        s.kor = 100;
        s.eng = 60;
        s.math = 76;
        System.out.println("이름 " +s.name);
        System.out.println("총점 " +s.getTotal());
        System.out.println("평균 " +s.getAverage());
    }
   
}
