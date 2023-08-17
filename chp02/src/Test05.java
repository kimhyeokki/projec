import java.util.Scanner;

public class Test05 {
    public static void main(String[] args) {
        int remain=0;
        int unit[] = {50000, 10000,5000,1000,500,100,50,10};
        Scanner scanner =new Scanner(System.in);
        System.out.println("금액을 입력하면 지폐로 바꿔드립니다.");
        int won =scanner.nextInt();
        //0장이면 출력에서 배제한다.
        for(int i =0;i<unit.length;i++){
            remain= won/ unit[i];
            won= won% unit[i];
            if(remain!=0){
                System.out.println(unit[i] +"원 " + remain + "장");
            }
        }
        
    }
}
