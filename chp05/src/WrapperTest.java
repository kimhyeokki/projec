import javax.swing.event.InternalFrameAdapter;

public class WrapperTest {
    public static void main(String[] args) {
        char ch = 'A';
        char ch01 = '9';
        Character.toLowerCase(ch); 
        Character.isDigit(ch);                                  //isDigit() 숫자 아닌지 확인

        System.out.println(Character.toLowerCase(ch));
        System.out.println(Character.isDigit(ch));
        System.out.println(Character.isDigit(ch01));
        System.out.println(Character.isAlphabetic(ch));
        System.out.println(Character.isAlphabetic(ch01));       //isAlphabetic() 알파벳인지 아닌지 확인

        String str = "40";
        int num =40;
        Integer.parseInt(str);
        System.out.println(Integer.parseInt(str)+2);            //parseInt() 문자를 정수로 변환
        Integer.toHexString(num); 
        System.out.println(Integer.toHexString(num));           //16진수로 변환
        System.out.println(Integer.toBinaryString(num));        //2진수로 변환
        System.out.println(Integer.toString(num));              //문자로 변환
        System.out.println(str.equals(Integer.toString(num)));  //결과값은 ture

        double d = 3.14;
        String d2 ="3.14";
        System.out.println(Double.toString(d)); 
        System.out.println(Double.parseDouble(d2));             //문자를 double로 변환
                                                                //parseInt, parseDouble 많이 사용되니 중요함
        //----------------------------Boxing unboxing--------------------//
        
        Integer ten =10;  //<- Integer ten = Integer.valueOf(10); Boxing
        int ten02 = ten;  //unboxing
        int ten03 = 10;
        System.out.println(ten==ten03);   
        
        Integer num01 = 12345;
        Integer num02 = 12345;
        System.out.println(num01==num02);               //다른 참조 그래서 false
        System.out.println(num01.equals(num02));        // 값을 비교하는 것 ture
        //


    }
}
