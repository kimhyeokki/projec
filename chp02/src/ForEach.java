public class ForEach {
    public static void main(String[] args) {
        int intArray[] = {1,2,3,4,5};
        int i=0;
        for(int num : intArray){
            System.out.println(num);
            i++;
            System.out.printf("intArray[%d] :%d %n",i ,num);
        }
        enum Week {Mon, Tue,Wed,Thu,Fri,Sat,Sun} //문자열타입만 가능? 나열한다, enum 변수이름선언 {.....}
        //변수이름.values() 배열 만들어준다.
        Week day[] =Week.values();

        //  for(Week day : Week.values()){
        //     System.out.println(day);
        // }

    }
}
