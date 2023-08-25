// 정수 3개를 입력받아 총합을 구한다.
// 이때 정수가 아닌 문자를 입력하는 애들도 있다.
//프로그램이 종료 되지 않고 끝까지 실행되게 끔 코딩하시오

import java.util.InputMismatchException;
import java.util.Scanner;

public class Quiz01 {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int sum=0; int num=0;
        
            for(int i =0;i<3;i++){
                try {
                    num = scanner.nextInt();
                } catch (InputMismatchException e) {
                    // TODO: handle exception
                    System.out.println("정수만 들어와야 합니다.");
                    scanner.next();
                    i--;
                    continue;
                }
                sum +=num;
            }
            System.out.println("세정수의 합은 "+sum);
       
        
    }
}
