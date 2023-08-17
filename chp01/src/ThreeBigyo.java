import java.util.Scanner;

public class ThreeBigyo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int result=0;
        if(a<c && a>b){
            result=a;
        } else if(a>c && b>a){
             result=a;                  //if((a<c && a>b) || (a>c && b>a)) 앞에 조건을 만족하거나 뒤에 조건을 만족하면 참
        } else if(a<b && b<c){
             result=b;
        } else if(c<b && b<a){
             result=b;
        } else{
             result=c;
        }
        System.out.println(result);
        scanner.close();
    }
}
