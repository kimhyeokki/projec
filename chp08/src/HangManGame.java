import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class HangManGame {
    //
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("c:\\temp\\words.txt");
            List<String> str = new ArrayList<>();
            Scanner scanner = new Scanner(fileReader);
            while(scanner.hasNext()){
                String word = scanner.nextLine();
                str.add(word);
            }
            scanner.close();
            
            Scanner serachScanner = new Scanner(System.in);
            while(true){
                int ran =(int)(Math.random()*str.size());
                System.out.println(str.get(ran));
                String find = str.get(ran);
                char a = find.charAt((int)(Math.random()*find.length()));
                StringBuffer hiddeString = new StringBuffer(find);
                for(int i =0;i<find.length();i++){
                    if(hiddeString.charAt(i) ==a){
                        hiddeString.setCharAt(i, '-');
                    }
                }
                System.out.println(hiddeString.toString());
                System.out.println("단어를 맞추시오");
                String ch = serachScanner.nextLine();
                if(ch.equals("그만"))
                break;
                char ch02 = ch.charAt(0);
                for(int i =0;i<find.length();i++){
                    if(hiddeString.charAt(i)=='-'&& find.charAt(i)==ch02){
                        System.out.println("맞음");
                        System.out.println(find);
                        System.out.println("한게임 더 하시겠습니까 y/n");
                    }
                }
               

            //     if(ch.charAt(0) ==a){

            //         System.out.println("딩동댕");
            //         break;
            //     }else{
            //     System.out.println("떙");
            // }

            }
        } catch (FileNotFoundException e) {
          
            e.printStackTrace();
        }
    }
}
