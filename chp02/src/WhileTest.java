import java.util.Scanner;

public class WhileTest {
    public static void main(String[] args) {
        // while (i<10) {  //while문은 조건에 ture를 사용해서 무한루프 사용할 경우가 있다
        //     i++;
        //     System.out.println(i);
        // }
        Scanner scanner = new Scanner(System.in);
        int aa = scanner.nextInt();
        int count=0;
        int sum=0;
        double avg;
        while(0<aa){
            count++;
            sum = sum + aa;
            aa = scanner.nextInt();
        }
        avg = (double)sum/count;  //타입 변환 ex) (int)34.2  =34 / (double) 32 = 32.0
        System.out.println("입력한 정수의 갯수는 " +count+" 평균은" +avg+"입니다" );
    }
}
