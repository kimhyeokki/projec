public class DoWhileTest {
    public static void main(String[] args) {
        int i=0;
        char c='A';
        do{
            System.out.println(c);
             c=(char)(c+1);
        }while(c<='Z');
        // do{
        //     System.out.println(i);   //먼저 실행 후 while 조건에 만족하는지 확인함
        //     i++;
        // } while(i<10);
    }
}
