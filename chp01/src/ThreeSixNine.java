import java.util.Scanner;

public class ThreeSixNine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int ten = a/10;
        int one = a%10;
        if(ten==0 && one%3 ==0){
            System.out.println("짝");
        } else if(ten%3 == 0 && one==0){
            System.out.println("짝");
        } else if(ten%3 ==0 && one%3 !=0){
            System.out.println("짝");
        } else if(ten%3 !=0 && one%3 ==0){
            System.out.println("짝");
        } else if(ten%3 ==0 && one%3 ==0){
            System.out.println("짝짝");
        }
             else {
            System.out.println(a);}
            scanner.close();
    }
}
