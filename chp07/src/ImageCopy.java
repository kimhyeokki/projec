import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCopy {
    public static void main(String[] args) {
        File sourceImg = new File("c:\\temp\\son.jpg");
        File copyImg = new File("c:\\temp\\copy-son.jpg");
        try {
            if(!copyImg.exists()){
                copyImg.createNewFile();
                FileInputStream fileInputStream = new FileInputStream(sourceImg);
                FileOutputStream fileOutputStream = new FileOutputStream(copyImg);
                byte buffer [] = new byte[1024*10];
                long before = System.currentTimeMillis();
               while(true){
                   int end = fileInputStream.read(buffer);
                   fileOutputStream.write(buffer, 0, end);
                   if(end<buffer.length)
                   break;
               }
                // int c;
                // while((c=fileInputStream.read()) !=-1)
                // {
                //     fileOutputStream.write((byte)c);
                // }
                long after =System.currentTimeMillis();
                System.out.println(after-before);
                fileOutputStream.close();
                fileInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }    
        
    }
}
