public class AbsTest {
    public static void main(String[] args) {
        int a = 5;
        int b = 8;
        int result;
        if(a-b <0){
            int c = b-a;
            System.out.println(c);
        } else if(a-b>0){
            int c = a-b;
            System.out.println(c);
        }
        //삼항연산자
        result = a>b ? a-b : b-a;
        System.out.println(result);
      

    }
}
