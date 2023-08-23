import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Quiz01 {
    public static void main(String[] args) {
        File file = new File("c:\\temp\\text04.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        FileWriter fileWriter = null;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            fileWriter = new FileWriter("c:\\temp\\text04.txt");
            fileWriter.write(input, 0, input.length());
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileReader fileReader =null;
        try {
            fileReader = new FileReader("c:\\temp\\text04.txt");
            int c;
            while((c=fileReader.read())!=-1){
                System.out.print((char)c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
