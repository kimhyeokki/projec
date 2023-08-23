import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("홍길동");
        arrayList.add("임꺽정");
        arrayList.add("심청이");
        arrayList.add("둘리");
        arrayList.add(0,"고길동"); //해당되는 위치에 요소 추가 //사이에 끼워 넣는 느낌
    //    arrayList.remove(0);
    //   arrayList.remove("고길동");
        arrayList.set(0, "코난");  //해당되는 위치에 요소 저장 //즉 삭제후 요소 저장
        for(int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
        System.out.println('\t');
        for(String str:arrayList){
            System.out.println(str);
        }
        //arrayList.clear(); // 전부삭제
        System.out.println(arrayList.isEmpty()); //빈공간 참인지, 거짓인지 확인
        System.out.println(arrayList.contains("둘리"));  //해당 요소가 있는지 확인

        ArrayList<Integer> intarrayList = new ArrayList<>(Arrays.asList(11,21,31,41,51));  //==intarrayList.add(11....51);
        System.out.println(intarrayList.get(0)); 

        ArrayList <String> strArrayList = new ArrayList<>(Arrays.asList("고길동","홍길동","둘리","미켈란젤로"));
   //이름이 제일  긴 사라 출력?
        int longIdx =0;
        for(int i=0;i<strArrayList.size();i++){
            if(strArrayList.get(i).length()>strArrayList.get(longIdx).length()){
                longIdx = i;
            }
        }
        System.out.println(strArrayList.get(longIdx));
            //    for (String string : strArrayList) {
            //     System.out.println(string);
            //    }
    }
}
