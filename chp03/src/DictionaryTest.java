import java.util.Scanner;

class Dictionary{
   static String kor[] = {"사과","자두","포도"};
   static String eng[] = {"apple","plum","grape"};
    public static String korToEng(String word){
        for(int i=0;i<kor.length;i++){
            if(kor[i].equals(word)){
                return eng[i];
            }
        }
        return null;
    }
}

public class DictionaryTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            String words = scanner.next();
            if(words.equals("그만"))
            break;
            String myeng =Dictionary.korToEng(words);
            if(myeng==null){
                System.out.println("없는 단어 입니다 다시 출력해주세요");
            } else{
                System.out.printf("%s의 영단어는 %s 입니다",words, myeng);
            }
        }
        
    }
    
}
