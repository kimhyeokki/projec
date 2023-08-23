import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            fileReader =new FileReader("c:\\Windows\\system.ini");
            int c;
            while ((c = fileReader.read())!= -1 ) {  // fileReader() int타입이고 문서의 끝이 -1로 리턴 된다.
                System.out.print((char)c);   // int 타입으로 나오기 때문에 문자로 변환 하기 위해서 char 형변환하였음
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
