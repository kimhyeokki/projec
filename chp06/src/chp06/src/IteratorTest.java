import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        String strArray[] = {"둘리","희동이","도우너"};
        Integer array[] ={1,2,3,4,5};  // 기본 타입은 못들어갑니다...ex) int..-> Integer
        ArrayList<String> strarrayList = new ArrayList<>(Arrays.asList(strArray));  //==intarrayList.add(11....51);
        System.out.println(strarrayList.get(0)); 
        System.out.println(strarrayList.get(1)); 
        System.out.println(strarrayList.get(2)); 

        ArrayList<Integer> intarrayList = new ArrayList<>(Arrays.asList(array));  //==intarrayList.add(11....51);
        System.out.println(intarrayList.get(0)); 
        System.out.println(intarrayList.get(1)); 
        System.out.println(intarrayList.get(2)); 

        ArrayList<Integer> intArray = new ArrayList<>();
        intArray.add(11);
        intArray.add(22);
        intArray.add(33);
        intArray.add(44);
        Iterator<Integer> it =  intArray.iterator();
        // System.out.println(it.next());
        // System.out.println(it.next());
        // System.out.println(it.next());
        // System.out.println(it.next());
        while(it.hasNext()){           //hasNext() boolean 타입 다음에 요소가 있는지 없으면 false
            System.out.println(it.next());  //next() 다음 요소를 읽어옴
        }

        //List<StudentDto> studentList = new ArrayList();
    }
}
