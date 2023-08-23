import java.io.FileWriter;
import java.util.Scanner;

public class FileWriterTest {
    public static void main(String[] args) {
        //파일 쓰기
        Scanner scanner =new Scanner(System.in);
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter("C:\\temp\\test.txt");
            while(true){
                String line =scanner.nextLine();
                if(line.length()==0)
                break;
                fileWriter.write(line,0,line.length());
                fileWriter.write("\r\n",0,2); //줄바꿈 : \r\n(Windows), \r(MAC)
            }
            fileWriter.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
