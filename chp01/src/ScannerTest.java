import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        System.out.println("이름, 도시, 나이, 체중, 결혼 유무를 분리하여 입력해주세요");
      //  new java.util.Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        String myName =  scanner.next();
        String myCity = scanner.next();
        int age = scanner.nextInt();
        double myWeight = scanner.nextDouble();
        boolean myWedd = scanner.nextBoolean();
        System.out.println("내이름은 " + myName);
        System.out.println("사는 곳은 " + myCity);
        System.out.println("나이 " + age);
        System.out.println("몸무게는 " + myWeight);
        System.out.println("결혼유무 " + myWedd);
        scanner.close();
    }
}
