// 3번 문제를 배열의 갯수를 리터해서 구하는 방법

import java.util.Scanner;

public class Quiz04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String array[] = str.split(" ");
        System.out.println(array.length);
        
    }
}
