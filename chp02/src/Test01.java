public class Test01 {
    public static void main(String[] args) {
       int sum=0;
        for(int i=1;i<101;i+=2){
            sum = sum + i;
            System.out.println(sum);
        }
        System.out.println(sum);
    }
}
