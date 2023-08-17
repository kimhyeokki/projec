public class CircleArea {
    public static void main(String[] args) {
        final double radius = 3.5;  //final 상수 선언 ==const 와 비슷함
        double PI = 3.14;
        double result = radius*radius*PI;
        int myMoney = 1_000_000; 
        boolean isTure = true;
        String str =null; //레퍼런스 타입에는 null 사용가능, 기본타입엔 불가능함
        String sstr="하나의 객체";

        System.out.println(result);
        System.out.println(isTure);
    }
}
