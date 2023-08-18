package com.javalecture.quiz;

public class Student01 {
    
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;
    int sum;
    double avg;
    
    public Student01(String name, int ban, int no, int kor, int eng, int math) {
      this.name = name;
      this.ban = ban;
      this.no = no;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
      sum = kor+eng+math;
      avg = (double)(sum/3);
  }
    
    String info(){
        return name;
    }

    public static void main(String[] args) {
        Student01 s =new Student01("홍길동", 1, 1, 100, 60, 76);
        String str =s.info();
        System.out.println(str);
    }
}
