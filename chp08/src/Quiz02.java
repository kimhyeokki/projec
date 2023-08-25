// 두수를 입력받아 연산의 결과를 출력하는 프로그램을 짜시오 이때 실수를 입력하면 오류가 나면서
//종료되지 않게 하세요

import java.util.InputMismatchException;
import java.util.Scanner;

public class Quiz02 {
    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     int sum=0;
     int sub=0;
     int temp =0;
     int mutl=1;
     int div=1;
     int a= 0;
     for(int i = 0 ; i<2;i++){
         try {
            a = scanner.nextInt();
            
        } catch (InputMismatchException e) {
            // TODO: handle exception
            i--;
            System.out.println("예외입니다.");
            scanner.next(); // catch에서 삭제하기 위해 
            continue;
        }
        sum += a;
       
        sub = a-sub;
        mutl = mutl*a;
        div  = a/div;
    }
    System.out.println((sum)+","+(sub)+","+(mutl));
     

    }
}
