import java.util.Scanner;

public class GradeSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("점수를 입력하시오");
        int score = scanner.nextInt();
        char grade;
        switch(score/10){ //조건식에는 연산 사용가능  case 결과값은 int, string, char의 형식만 가능
            case 10 :
            case 9 : grade='A';
            break;
            case 8 : grade='B';
            break;
            case 7 : grade='C';
            break;
            case 6 : grade='D';
            break;
            default : grade = 'F';
            break;
        }
        System.out.println(grade);
        scanner.close();
    }
}
