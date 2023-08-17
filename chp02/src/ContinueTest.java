import java.util.Scanner;

public class ContinueTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("정수 다섯개를 입력하시오");
        int sum=0;
        for(int i=0; i<5; i++){
            int a = scanner.nextInt();
            if(a<0)
            continue;
            sum += a;
        }
        System.out.println("양의 정수의 합은 "+sum);
    }
}
