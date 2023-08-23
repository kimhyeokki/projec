//scanner 을 통해 이름과 전화번호를 입력받는다.
//이때 그만을 입력하면 종료한다.
// temp 퐁더에 Phone.txt. 파일에 입력한 전호번호를 저장 하시오
//(줄바꿈이 되어야한다.)
//방금 입력한 phone txt를 읽어서 system에 출력하시오

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Quiz02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("c:\\temp\\Phone.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file);
                while (true) {
                    String stdinfo = scanner.nextLine();
                    if(stdinfo.equals("그만"))
                    break;
                    fileWriter.write(stdinfo, 0, stdinfo.length());
                    fileWriter.write("\r\n");  //줄바꿈
                }
                fileWriter.close();  //반드시 닫아야 작성이 됨
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileReader fileReader= null;
        long before = System.currentTimeMillis();
        try {
            fileReader = new FileReader(file);
            int c;
            while((c=fileReader.read()) !=-1)
           {
                System.out.print((char)c);
            }
            fileReader.close();
            long after = System.currentTimeMillis();
            System.out.println(after-before);
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
}
