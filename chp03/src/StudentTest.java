public class StudentTest {
    public static void main(String[] args) {
        Student st01 = new Student(1, "김혁기", 3.4,"남자");
       st01.setScore(4.0);
       st01.setGender("여자");
    
       System.out.printf("이 학생의 학점은 %.2f %n 성별은 %s",st01.getScore(), st01.getGender());
    }
}
