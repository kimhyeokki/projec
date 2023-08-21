//scanner에서 글자를 입력받아 낱말의 갯수가 몇개인지 출력하는 프로그램 작성

import java.util.Scanner;
import java.util.StringTokenizer;

public class Quiz03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(str," ");
        int total = st.countTokens();
        System.out.println(total);
        
    }
}
