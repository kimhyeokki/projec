public class Test02 {
    public static void main(String[] args) {
        int sum=0;
        for(int i=0; i<101; i+=2){
            sum += i;
            System.out.println(sum);
        }
        System.out.println(sum);
    }
}
