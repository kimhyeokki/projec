import java.util.Scanner;

public class Above80 {
    public static void main(String[] args) {
        //키보드로부터 정수를 입력ㅂ다아 80이상이면 합격 불합격
        System.out.println("점수를 입력하시오");
        Scanner scanner = new Scanner(System.in);  //입력하기위해
        int nums = scanner.nextInt();              // 사용자가 입력한 값
        if(nums%3 ==0){
            System.out.println("3의 배수");
        } else {
            System.out.println("불합격");
        }
        scanner.close();
    }
}
