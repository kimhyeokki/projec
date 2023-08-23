//나라이름과 인구수를 입력하여

import java.util.HashMap;
import java.util.Scanner;

public class Quiz03 {
    public static void main(String[] args) {
        HashMap<String,Integer> hash = new HashMap<>();
        hash.put("한국",5000);
        hash.put("중국",140000);
        hash.put("미국",30000);
        hash.put("일본",10000);
        Scanner scanner = new Scanner(System.in);
        while(true){
            String nation = scanner.next();
            if(nation.equals("그만"))
            break;
            Integer pop = hash.get(nation);  //why int 말고 Integer int에는 null값이 받을 수 없습니다.
            if(pop==null){
                System.out.println("없는 나라입니다.");
            }else{
                System.out.println(pop);
            }
        }
    }
}
