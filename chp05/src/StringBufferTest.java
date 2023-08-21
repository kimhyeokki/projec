import java.util.StringTokenizer;

public class StringBufferTest {
    public static void main(String[] args) {
       // String str =new String("this");  //불변 객체
       // str.concat(" is not pipe");
       // System.out.println(str);
        StringBuffer sb =new StringBuffer("this");  //가변 객체
        sb.append(" is not pipe");
        System.out.println(sb);
        sb.insert(11,"AB");  //사용자가 지정한 위치에 문자열 추가가능
        System.out.println(sb);
        sb.replace(13, 14, " apple ");
        System.out.println(sb);
        sb.delete(13, 19);
        System.out.println(sb);
        //String, StringBuffer 
        StringTokenizer st = new StringTokenizer("홍길동/심청전/콩쥐/팥쥐/개구리/왕눈이", "/"); //split 과 비슷함
        if(st.hasMoreTokens()){
        System.out.println(st.nextToken());  //배열은 아님
        }
        
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
        

       
    }
}
