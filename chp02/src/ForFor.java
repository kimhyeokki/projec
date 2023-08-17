public class ForFor {
    public static void main(String[] args) {
        //구구단 만들기
        int i=1;
        int j=1;
        int result =0;
        for(i=1;i<10;i++){        
            if(i%2==0)
            continue;              //홀수만 구구단 만들려면 
            for(j=1;j<10;j++){
                System.out.println(i + "x" + j + "=" + i*j);
               System.out.println('\t'); //줄바꿈
            }
            System.out.println("");
        }
        //continue 건너뛰는 기능   //break 빠져나간다 즉 실행되고 있는 반복문이나 조건문을 끝내버린다. 
    }
}
