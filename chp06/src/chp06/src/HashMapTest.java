import java.util.HashMap;
import java.util.Set;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("apple", "사과");
        map.put("plum", "자두");
        map.put("peach", "복숭아");
        //System.out.println(map.get("apple"));
        Set <String> keys = map.keySet();
        Iterator <String> it = keys.iterator();
        while (it.hasNext()) {
            
            System.out.println(it.next());
        }

        LinkedHashMap<String,String> map01 = new LinkedHashMap<>();  //Linked -> 순서 보장해줌 ArrayList 와 비슷함
        map01.put("apple", "사과");
        map01.put("plum", "자두");
        map01.put("peach", "복숭아");
        System.out.println(map01.keySet());
        System.out.println(map.keySet());
        //Quiz03 
        //학생 3명의 이름과 점수를 HashMap으로 만들어서 이름과 점수 출력하기

        HashMap<String,Integer> student = new HashMap<>();
        student.put("손흥민",100);
        student.put("김하성",98);
        student.put("류현진",85);
        for(String str: student.keySet()){
            System.out.println(student.get(str));
        }
        Set<String> itt = student.keySet();
        Iterator<String> key  = itt.iterator();
        while (key.hasNext()) {
            System.out.println(key.next());
        }
        
    }
}
