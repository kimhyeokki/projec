import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class PhoneExplorer {
    public static void main(String[] args) {
        // 키 value 를 이용 HashMap을 <string,String>
        HashMap<String,String> phoneMap = new HashMap<>();
        phoneMap.put("김혁기", "010-1111-2222");
        phoneMap.put("장성호", "010-2222-3333");
        phoneMap.put("장동건", "010-3333-4444");
        Set<String> keySet = phoneMap.keySet();
        Iterator<String> it = keySet.iterator();
        File file = new File("c:\\temp\\Phone.txt");
        try {
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            System.out.println(file.getPath()+"를 출력합니다");
            while (scanner.hasNext()) {
               String str = scanner.nextLine();
                System.out.println(str);
            }
            while(it.hasNext()){
                String name = it.next();
                System.out.println(name+phoneMap.get(name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
