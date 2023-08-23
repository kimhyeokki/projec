import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextCopy {
    public static void main(String[] args) {
        File sourceFile = new File("c:\\windows\\system.ini");
        File copyFile = new File("c:\\temp\\system.txt");
        try {
            if(!copyFile.exists()){
                copyFile.createNewFile();
            }
            FileReader reader = new FileReader(sourceFile);
            FileWriter fileWriter = new FileWriter(copyFile);
            int c;
            while((c=reader.read()) !=-1){
                fileWriter.write((char)c);
            }
            fileWriter.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
