import java.util.ArrayList;
import java.util.Scanner;
//입력한 숫자중에 제일 큰 숫자 출력
public class Quiz01 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList();
        Scanner sc = new Scanner(System.in);
        while(true){
        int a1 = sc.nextInt();
        if(a1==-1)
        break;
        arrayList.add(a1);
        }
      int big =arrayList.get(0);  
       for(int i =1;i<arrayList.size();i++){
        if(arrayList.get(i) >big){
            big = arrayList.get(i);
        }
       }
            System.out.println(big);
    }
}
