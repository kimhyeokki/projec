import java.util.Scanner;

public class BreakTest {
    public static void main(String[] args) {
        //문자열을 입력 받아서 출력하는데 
        //exit 가 입력되면 종료합니다
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            String sen = scanner.nextLine();
            if(sen.equals("exit") || sen.equals("EXIT"))
            break;
        }
        System.out.println("종료합니다.");
    }
}
