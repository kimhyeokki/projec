import java.util.Scanner;

public class DivideZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력하시오");
        int num = scanner.nextInt();
        System.out.println("나눌 수를 입력하시오");
        int div = scanner.nextInt();
        try {
            System.out.println(num+"을 "+div+"나누면"+num/div+"입니다.");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("0으로 나눌 수 없습니다.");
        }
    }
}
