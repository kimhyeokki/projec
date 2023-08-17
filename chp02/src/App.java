public class App {
    public static void main(String[] args) throws Exception {
        int sum=0;
        for(int i = 1;i <=10;i++){
         
            System.out.println(i);
            sum += i;
            // == sum = sum+i;
            if(i<=9){
                System.out.println("+");
           
        } else{
            System.out.println("=");
            System.out.println(sum);
        }
        
    }
}
}
