//word.txt를 읽어서 
// 단어를 입력하면 해당되는 단어 출력하기

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordExplorer {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("C:\\temp\\words.txt");
            List<String> wordList = new ArrayList<>();
            Scanner scanner = new Scanner(fileReader);
            Scanner serachScanner = new Scanner(System.in);
            while(scanner.hasNext()){
                String str = scanner.nextLine();
                wordList.add(str);
            }
            scanner.close();
            while(true){
                System.out.println("단어를 입력하시오");
                String serachwords = serachScanner.nextLine();
                
                if(serachwords.equals("그만"))
                break;
                for(int i=0;i<wordList.size();i++){
                    String word = wordList.get(i);
                    if(serachwords.length() >word.length()){
                        continue;
                    }
                    String findword = word.substring(0, serachwords.length());
                    if(serachwords.equals(findword))
                    System.out.println(word);
                }
            }    
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
