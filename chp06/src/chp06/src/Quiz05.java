 //Quiz05 학생이름과 점수를 가지는 HashMap을 작성하고, 5명의 학생 이름과 점수를 입력하시어
    //이때 점수가 3.8이상인 학생을 출력해보기

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Quiz05 {
    public static void main(String[] args) {
        HashMap<String,Double> stdgrade = new HashMap<>();
        stdgrade.put("김혁기"  , 3.5);
        stdgrade.put("손흥민"  , 4.2);
        stdgrade.put("강호동"  , 4.0);
        stdgrade.put("이강인"  , 3.7);
        Set<String> set = stdgrade.keySet();
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
                if(stdgrade.get(it.next())>= 3.0){
                    System.out.println(it.next());
                } else{
                    System.out.println("장학금 미지급");
                }
            
        }
    }
}
