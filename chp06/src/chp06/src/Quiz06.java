import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
//나라와 수도를 10개 입력하고, 랜덤으로 나라 이름 출력되고 수도를 맞추면 딩동댕 아니 땡
//그만 쓰면 빠져나가기
public class Quiz06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String,String> naraname = new HashMap<>();
        naraname.put("한국", "서울");
        naraname.put("미국", "워싱턴");
        naraname.put("영국", "런던");
        naraname.put("프랑스", "파리");
        naraname.put("독일", "베를린");
        naraname.put("중국", "베이징");
        naraname.put("일본", "도쿄");
        naraname.put("러시아", "모스크바");
        naraname.put("스페인", "마드리드");
        naraname.put("이탈리아", "로마");
        
        Iterator<String> values = naraname.values().iterator();  // value도 keySet 처럼 할 수 있음
        Iterator<Map.Entry<String,String>> entries = naraname.entrySet().iterator(); //Map.Entry<>
        while(entries.hasNext()){
            String keyValue = entries.next().getKey();
            System.out.println(keyValue+":"+naraname.get(keyValue)); //getkey(), getvalue()을 통해 정보를 얻을 수 있음
        }
        // System.out.println(entries.next()); //== 결과값 프랑수=파리
        
        int total = naraname.size();
        Set<String> set = naraname.keySet();
        Object keyArray[]  = set.toArray();  //=> toArray() keySet을 배열로 만들어줌
       // System.out.println(keyArray[ran]);
       // Iterator<String> it = set.iterator();
        while(true){
            int ran = (int)(Math.random()*total);
            String name =(String) keyArray[ran];
            System.out.println(name+"의 수도 이름을 입력하시오");
            String cap = scanner.nextLine();
            if(cap.equals("그만"))
            break;
            if(cap.equals(naraname.get(name))){
                System.out.println("딩동댕");
            } else{
                System.out.println("떙입니다 다시 입력하시오");
            }
        }

    }
}
