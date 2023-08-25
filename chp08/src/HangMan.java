import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// 이런 코드드링 쌓이면 library  
class Words {
    // field
    List<String> wordsList = new ArrayList<>();

    public Words(String sourceFile) {
        File file = new File(sourceFile);
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                String word = scanner.nextLine();
                wordsList.add(word);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
            e.printStackTrace();
        }
    }

    public String getRandomWord() {
        int ran = (int) (Math.random() * wordsList.size());
        return wordsList.get(ran);
    }

}


public class HangMan {
    // words.txt 읽어와서
    // list에 넣기
    // 랜덤 단어 출력
    // horse
    // h-rse char하나 빼서 -로 대체하기...
    // 숨긴 char랑 내가 쓴 char가 맞으면 다음게임 진행
    // 그만
    private String randomWord;
    public Scanner scanner;
    public StringBuffer hiddenWord;
    public void go(){
        int count=0;
            while(true){
                String str = scanner.next();
                char ch02 = str.charAt(0);
                System.out.println(hiddenWord);
                if(trueOrFalse(ch02))
                break;
                if(trueOrFalse(ch02)==false){  //틀리면 종료
                    count++;
                }
                System.out.println(count);
                if(count==5)  // 5번 틀리면 종료합니다.
                break;
            }       
    }
     private boolean trueOrFalse(char ch){
        boolean result = false;
        for (int i = 0; i < randomWord.length(); i++) {
            if (hiddenWord.charAt(i) == '-' && randomWord.charAt(i) == ch) {
                System.out.println("맞음");
                result= true;
            }
        }
        return result;
     }
    public void run(){
        System.out.println("HangManGame을 시작합니다");   
        Words words = new Words("c:\\temp\\words.txt");  //파일 읽어오기
        while (true) {  
            // 맞는지 틀렸는지 따져보기...
            // scanner에서 입력받은 글자중에 제일 첫번째 글자 찾아서
            // 글자 갯수만큼 반복문 돌려서
            randomWord = words.getRandomWord();  //랜덤하게 단어 나오고
            makeHidden();  //정답에서 해당하는 글자 하나만 '-'로 바꿔서 hiddenWord 만들기
            System.out.println(randomWord);
            System.out.println(hiddenWord);
            scanner = new Scanner(System.in);
            go();
           // 멈춰야 된다, 정답이면 
               System.out.println("한게임 더하시겠습니까? y/n");
               String yesOrNo = scanner.next();
               if(yesOrNo.equals("n")){
                   break;
               }
        }
    }
    public void makeHidden(){
        Random random = new Random();
       for(int j=0; j<2;j++){
           int idx = random.nextInt(randomWord.length());
           System.out.println(idx);
           char ch = randomWord.charAt(idx);
           hiddenWord = new StringBuffer(randomWord);
           for (int i = 0; i < randomWord.length(); i++) {
                   if (hiddenWord.charAt(i) == ch) {
                     StringBuffer hiddenWord = hiddenWord.setCharAt(i, '-');
                   }
               }
       }
       
        // System.out.println(randomWord + "/" + idx + "/" + randomWord.charAt(idx));
        
            
    }
    public static void main(String[] args) {
        HangMan hangMan = new HangMan();
        hangMan.run();
       
    }
}
