public class StringTest {
    public static void main(String[] args) {
        String a = new String(" Java");
        String b = new String(" ,Spr ing");

        System.out.println(a.length()); //a 문자의 길이
        System.out.println(b.length()); //b 문자의 길이
        System.out.println(a.concat(b));  //concat 추가
        System.out.println(a.contains("J"));  // 같은 문자가 있는지 확인
        a= a.trim();
        b= b.trim();
        System.out.println(a); //공백 사라짐       
        System.out.println(b); //공백 사라짐  but 문자 사이의 공백은 삭제 못함
        System.out.println(b.length());       

        String c= " ";
        String d =" \t\n";
        c.isEmpty();   //문자의 길이가 0인지 아닌지 확인
        System.out.println(c.isEmpty());  //길이가 0이면 true
        System.out.println(c.isBlank());  
        System.out.println(d.isBlank());  //공백 제거 후 길이가 0이면 true
        //isEmpty() 문자열의 길이가 0인지 아닌지 비교
        //isBlank() 문자열의 공백을 제거한 다음 길이가 0인지 아닌지 비교

        String e = "피곤한 월요일 월요일";
        char first = e.charAt(e.length()-1);
        System.out.println(first);
        int pos = e.indexOf("월");
        int lastPos = e.lastIndexOf("월"); //문자열의 뒤에서 부터
        System.out.println(pos);
        System.out.println(lastPos);

        String f = "hello java";
        String g  ="HELLO JAVA";
        System.out.println(f.equals(g));
        System.out.println(f.equalsIgnoreCase(g)); //대소문자 제외하고 비교
        System.out.println(f.toUpperCase());    // 알파벳을 대문자로
        System.out.println(g.toLowerCase());    // 알파벳을 소문자로   

        String str01 = "Hi~~ how are you fine thank you and you";
        String str02 = "HOW"; //대소문자 무시하고 포함되어 있는지 확인
        String str03 =str02.toLowerCase();
        System.out.println(str01.equalsIgnoreCase(str02));
        System.out.println(str01.contains(str03));

        String str04 = "점";
        str04.concat("심").concat("먹").concat("고 합시다"); //concat은 문자열만 추가 가능
        String str05 = str04 + "심"+"먹"+"고 합시다."+12+null+'A'; // 이건 다 가능
        System.out.println(str05);

        String str06 = new StringBuilder("ab")
        .append("cd")
        .append(10)
        .toString();  //StringBuilder객체에서 .append()는 모든 타입 추가 가능
        System.out.println(str06);

        String str07 = "꿍짝";
        String str07Repeat = str07.concat("꿍짝")
        .concat("꿍짝")
        .concat("꿍짝");
        System.out.println(str07Repeat);
        String str07Repeat02 = str07.repeat(4).trim();
        System.out.println(str07Repeat02);  
        //Quiz 쿵짝 쿵짝 쿵짝 쿵짝
    String str08=str07.concat(" ").repeat(4).trim();
        System.out.println(str08);

        String story ="아주 아주 먼 옛날 인어공주가 바다속에서 광어를 먹고 살았습니다.";
        story.contains("인어공주");  //참
        System.out.println( story.startsWith("아주")); //시작하는 지점에  '아주'라는 문자로 시작했는지
        System.out.println(story.endsWith("니다.")); //끝나는 지점에 '니다.'로 끝났는지 

        String str09 = "쥐를 잡자 개를 잡자 양도 잡자 돼지도 잡자 먹고 죽자 찍찍찍";
        System.out.println(str09.replace("쥐","개")); //문자 하나만 바꿀 수 있음
        System.out.println(str09.replaceAll("[쥐,개,양,돼지]","소")); //replacAll은 여러 문자를 바꾸는게 가능

        String str10 = "java,c#,spring,python,javascript";
        String array[] = str10.split(",");  // split은 문자열을 ','을 제거하고 쪼개서 배열을 만들어준다.
        for(int i =0;i<array.length; i++){
            System.out.println(array[i]);
        }
       String arrayTxt = String.join("/",array); //join()은 배열을 문자열로 변환
       System.out.println(arrayTxt);

       String str11= "안녕하세요. 점심 맛있게 먹었나요";
       System.out.println(str11.substring(0, 2)); //substring(시작하는 위치, 몇글자) 문자열을 자르기 위해 
       System.out.println(str11.substring(0, 6)); 

       
      }
}
