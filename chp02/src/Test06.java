import java.util.Scanner;

public class Test06 {
    public static void main(String[] args) {
        String words[][] ={{"apple","사과"},{"plum","자두"},{"grape","포도"}};
        Scanner scanner = new Scanner(System.in);
       
        //  반복문을 이용해서 
     int count=0;
        for(int i = 0; i<3;i++){
            
            System.out.println(words[i][0]+ ":");
              String aa = scanner.nextLine(); 
            if(aa.equals(words[i][1])){
                System.out.println("정답입니다");
            }else{
                System.out.println("틀렸습니다 다시 입력해주세요");
                i--;
                System.out.println(count);
            }
        }
      
    }
}
