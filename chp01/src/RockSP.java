import java.util.Scanner;

public class RockSP {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String a =scanner.next();
        String b =scanner.next();
        String result ="";
        String comResult ="";
        if(a.equals(b)){
            result="무승부";
        } else if((a.equals("바위") && b.equals("가위")) || (a.equals("보") && b.equals("바위")) ||(a.equals("가위") && b.equals("보"))){
            result ="철수가 이겼습니다";
        } else{
            result="영희가 이겻습니다.";
        }
        System.out.println(result);
        scanner.close();
    }
}
