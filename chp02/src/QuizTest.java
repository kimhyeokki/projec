import java.util.Scanner;

public class QuizTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //퀴즈, 양의 정수 5개를 입력 받아서 제일 큰 숫자 출력 하기
        int intArray[] = new int[5];
          for(int i=0;i<5;i++){
            int nums = scanner.nextInt();
            intArray[i] = nums;
          }
          //-------- 배열 생성----------//
        int max =0;
        int min =intArray[0];
        for(int i=0;i<5;i++){
            if(intArray[i]>max){
                max = intArray[i];
            } 
            if(intArray[i]<min){
            min =intArray[i];
            }
        }
        System.out.printf("제일 작은 수는 %d",min);
        System.out.printf("제일 큰 수는 %d",max);
    }
}
