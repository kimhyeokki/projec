import java.util.Scanner;

public class YunYean {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int year = scanner.nextInt();
       if((year%4==0 && year%100!=0)|| year%400==0){
        System.out.println("윤년");
       }else{
        System.out.println("평년");
       }
       scanner.close();
    }
}
