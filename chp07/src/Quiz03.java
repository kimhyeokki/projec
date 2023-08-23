import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Quiz03 {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        File file = new File("c:\\temp\\Phone.txt");
        try {
            bufferedReader = new BufferedReader(new FileReader(file)); //보조 스트림
            // byte buffer[] = new byte[1024];
            long before = System.currentTimeMillis();
            while (true) 
            {
            String line = bufferedReader.readLine(); //readLine()은 한줄씩 읽는다.
            if(line==null)
            break;    
                System.out.println(line);
            }
            long after = System.currentTimeMillis();
            System.out.println(after-before);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
