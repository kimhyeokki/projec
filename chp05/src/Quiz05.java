//hello를
//elloh
//llohe

import java.util.Scanner;

public class Quiz05 {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("hello");
       // Scanner scanner = new Scanner(System.in);
        //String iput = scanner.nextLine();
        String str01 = "hello";
        char temp = 0;
        for(int i=0;i<5;i++){
        temp = str.charAt(0);
        str =str.deleteCharAt(0);
        str.append(temp);
        System.out.println(str);
        }
        System.out.println('\t');
        
        String msg = str01;
        for(int i=0;i<str01.length();i++){
        String firststr = msg.substring(0, 1);
        String reststr = msg.substring(1);
        msg =  reststr +firststr ;
        System.out.println(msg);
        }
        
        

    }
}
