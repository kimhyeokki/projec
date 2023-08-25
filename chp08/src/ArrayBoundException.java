public class ArrayBoundException {
    public static void main(String[] args) {
        int intArray[] = new int[5];
        intArray[0] =10;
        try {
            for(int i =0; i<5;i++){
                System.out.println(intArray[i+1]);
            }
            
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("배열의 인덱스 범위를 벗어났습니다.");
        } finally{
            System.out.println("여기는 예외랑 상관없이 무조건 실행");
        }
    }
}
