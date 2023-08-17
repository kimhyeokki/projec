import java.util.Scanner;

public class Compare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
       
        if(a/10 == a%10)
        {
            System.out.println("Ture");
        } else{
            System.out.println("False");
        }
        scanner.close();
    }
}
