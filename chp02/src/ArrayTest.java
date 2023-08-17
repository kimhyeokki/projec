public class ArrayTest {
    public static void main(String[] args) {
        //자바 배열  타입이 있어서 갯수도 정해져있다.
        //collection arrayList  
        int intArray[] = new int[5];  //배열길이가 5개인 배열을 선언
       // int[] intArray = new int[5];
       intArray[0] = 90;
       intArray[1] = 80;
       intArray[2] = 70;
       intArray[3] = 60;
       intArray[4] = 50;
       System.out.printf("Hello, %s, %s %n","World", "java");  // %n 줄바꿈
       System.out.printf("Hello, %d, %d %n",500, 200);  // %n 줄바꿈
       System.out.printf("Hello, %f, %f %n",30.0, 100.1);  // printf는 (format :" ,%s, %f or %d", 문자열, 실수 or 정수)
       for(int i =0; i<intArray.length; i++){
        //    intArray[0]:90;
        //    intArray[1]:80;
        //    intArray[2]:70;
        //    intArray[3]:60;
        //    intArray[4]:50;
        //    System.out.println("intArray["+i+"]:"  + intArray[i]);
           // System.out.println(intArray[i]);
           System.out.printf("intArray[%d]:%d %n",i,intArray[i]);
       }
       System.out.println('\t'); //줄바꿈
       System.out.println(intArray.length);
    }
}
