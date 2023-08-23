import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        File file = new File("C:\\temp\\test03.txt");
        File folder = new File("C:\\temp\\sample"); //폴더 생성 (확장자 없이 사용한다)
        File tempfolder =new File("c:\\temp");
        File fileArray[] = tempfolder.listFiles();  // 폴더랑 파일을 전부 배열로 반환함.
        System.out.println(fileArray.length);  //배열을 String으로 변환 Arrays.toString(fileArray)
        if(!folder.exists()){
            folder.mkdir();  //새로운 폴더 생성
        }
        System.out.println(file.exists());
        System.out.println(folder.isDirectory());
        //생성 및 삭제 할때 if 문 처리하면 좋다.
        // if(file.exists()){
        //     file.delete();
        // }
        if(!file.exists()){
            try {
                file.createNewFile(); //새로운 파일 생성
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.getPath()+","+file.getParent()+","+file.getName());
        //Quiz01 : test04.txt 파일을 만들어서 Hello java 글써놓기
    }
}
