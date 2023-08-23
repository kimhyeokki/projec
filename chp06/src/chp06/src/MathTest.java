import java.util.UUID;

public class MathTest {
    public static void main(String[] args) {
         System.out.println(Math.PI);
         System.out.println(Math.E);
         System.out.println(Math.ceil(3.14));  // 무조건 올림
         System.out.println(Math.floor(3.14)); // 소수점 버림 
         System.out.println(Math.round(3.14));  //소수점 첫째자리에서 반올림 retrun 타입 long
         System.out.println(Math.sqrt(9));     //제곱근 함수

         int x1 =100;
         int y1 =100;
         int x2 = 300;
         int y2 =300;

        double distance = Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));   //Math/pow(값의 수, 제곱 수)제곱 함수
        System.out.println(distance);

        System.out.println(Math.random());
        System.out.println(UUID.randomUUID().toString());
    }
}
