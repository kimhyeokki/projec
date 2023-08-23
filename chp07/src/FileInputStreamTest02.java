import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileInputStreamTest02 {
    public static void main(String[] args) {
        byte b[] = new byte[7];
        FileInputStream fInputStream =null;
        try {
            fInputStream =new FileInputStream("C:\\temp\\test.out");
            int c;
            int n=0;
            while((c = fInputStream.read()) !=-1){
                b[n] = (byte)c;
                n++;
            }
            for(int i=0; i<b.length;i++){
                System.out.println(b[i]);
            }
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
