import java.util.Scanner;

public class OperateTest {
    public static void main(String[] args) {
        
        //초를 정수 입력받기
        //5000초 h,M,S 인지 출력
       Scanner scanner = new Scanner(System.in);
       System.out.println("초를 입력하면 시분초를 알려드립니다");
       int temp = scanner.nextInt();
       //System.out.println(temp);
       double hour = (temp/60)/60; 
       double min = (temp/60)%60; 
        double sec =temp%60;
        System.out.println(temp+"초는" +hour + "시간" +min + "분" +sec +"초"+"입니다" );
        scanner.close();
    }
    
    
}
