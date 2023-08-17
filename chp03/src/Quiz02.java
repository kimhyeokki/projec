class Grade{
    int math;
    int kor;
    int eng;

    Grade(int math, int kor, int eng){
        this.math =math;
        this.kor = kor;
        this.eng = eng;
    }
    int average(){
        return (math+kor+eng)/3;
    }
    int average(int math, int kor, int eng){
        return (math+kor+eng)/3;
    }
    double average(int math, int kor, double eng){
        return (math+kor+eng)/3;
    }
}

public class Quiz02 {
   //grade 라는 클래스 만들고 math, kor, eng, 세개의 필드 구성, int average 라는 매서드 만들어서 평균 구하기, 생성장 함수는 3개의 매개변수를  가지게만듬 
    public static void main(String[] args) {
        Grade grade =new Grade(80, 80, 70);
        grade.eng = 80;
        int myAverage =grade.average();
        double average = grade.average(30,30,40.8);
        System.out.println(myAverage);
        System.out.printf("세과목의 평균은 %f",average);
    }
   
}
