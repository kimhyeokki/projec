public class MethodOverload {
   

    

    int getSum(int i, int j) {
        return i+j;
    }
    int getSum(int i, int j, int k){
        return i+j+k;
    }
     // 메서드 오버로딩해서 사용가능 
    // 같은 함수 이름 사용가능 IF 매개변수 갯수가 다르거나 타입이 다를때 예외) retrun 타입은 반영 X
    public static void main(String[] args) {
        MethodOverload m01 = new MethodOverload();
        int m01sum = m01.getSum(10, 2, 7);
        System.out.printf("세 숫자의 합은 %d",m01sum);

    }
}
