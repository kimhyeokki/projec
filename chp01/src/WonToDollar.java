import java.util.Scanner;

public class WonToDollar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int won = scanner.nextInt();
        int dollar =scanner.nextInt();
        final double rate = 1380.0;
        double result = won/rate;
        double myResult = dollar*rate;
        // 소수점 둘째짜리 구할려면
       double realResult = Math.round(result*100.0)/100.0;
        System.out.println(result);
        System.out.println(realResult);
        System.out.println(myResult);
        scanner.close();
    }
}
