//system.ini 파일을 읽어서 전부 대문자로 system에서 출력해보기

import java.io.FileNotFoundException;
import java.io.FileReader;



public class Quiz04 {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("c:\\windows\\system.ini");
            int c; 
            while((c=fileReader.read())!=-1){
                char ch = (char)c;
                ch = Character.toUpperCase(ch); //char 대문자
                System.out.print(ch);
                //== if(c>=97 && c<123){
                //     System.out.print((char)(c-32));
                // }else{
                //     System.out.print((char)c);
                // }
            }
                  } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
