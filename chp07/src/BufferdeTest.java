import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;

public class BufferdeTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            fileReader =new FileReader("C:\\temp\\test.txt");
            BufferedOutputStream bOutputStream = new BufferedOutputStream(System.out,5); //5개씩 흘려 보내준다.
            int c;
            while((c=fileReader.read()) !=-1){
                bOutputStream.write(c);
            }
            bOutputStream.flush(); //나머지 출력해준다.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
