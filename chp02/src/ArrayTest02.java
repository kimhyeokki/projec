public class ArrayTest02 {
    public static void main(String[] args) {
        int intArray[] = {10,20,30,40,50,60,}; // 선언과 동시에 변수값을 넣을 때에는 중괄호 사용가능하다
        //동물이름 배열 길이 5개를 만들고 출력 한다.
        String catArray[] = new String[5];
        String aniArray[] ={"pig","dog","cat","lion","tiger"};
        System.out.println(catArray.length);
        for(int i=0;i<aniArray.length;i++){
           // System.out.println(aniArray[i]);
            System.out.printf("aniArray[%d]: %s %n" , i, aniArray[i]);
        }
        //퀴즈, 양의 정수 5개를 입력 받아서 제일 큰 숫자 출력 하기
    }
}
