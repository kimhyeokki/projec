
import java.util.Arrays;
import java.util.Scanner;

public class Test04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   
       int intArray[] = new int[10];
        for(int i=0;i<9;i++){
            int nums = scanner.nextInt();
            intArray[i] =nums;     
        }
        for(int i=0;i<intArray.length;i++){
            if(intArray[i]%3==0){
                System.out.print(intArray[i]+"/");
            }
        }
        System.out.println(Arrays.toString(intArray));
    }
}
