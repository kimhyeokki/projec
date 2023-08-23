import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileInputStreamTest {
    public static void main(String[] args) {
       InputStreamReader inputStreamReader = null;  //파일을 읽기 위한
       FileInputStream fileInputStream = null;      //파일을 입력(가져오는)
       Charset charset = StandardCharsets.UTF_8;
       try {
        fileInputStream = new FileInputStream("c:\\temp\\test.txt");
        inputStreamReader = new InputStreamReader(fileInputStream, charset);// file, 파일의 인코딩 타입
        System.out.println(inputStreamReader.getEncoding()); //인코딩 타입을 알수 있는 mathod
        int c;
        while ((c= inputStreamReader.read()) !=-1 ) {
            System.out.print((char)c);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
