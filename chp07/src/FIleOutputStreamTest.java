import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FIleOutputStreamTest {
    public static void main(String[] args) {
        byte b [] = {10,20,30,40,50,60,70};  //문자가 아닌 바이트일땐 스트림만 사용해야함
        FileOutputStream fileOutputStream =null;
        try {
            fileOutputStream = new FileOutputStream("c:\\temp\\test.out");
            for(int i=0;i<b.length;i++){
                fileOutputStream.write(b[i]);
            }
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
