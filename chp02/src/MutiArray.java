import java.util.Arrays;

public class MutiArray {
    public static void main(String[] args) {
        //행과 열
        int intArray[][] = new int[2][3];  //이중 배열 선언 
        double score[][] ={{2.5,3.4},{3.5,4.0},{3.8,4.1},{4.2,4.4}};
        //== double score[][] = new double[4][2]
        System.out.println(score[2][0]);
        System.out.println(score[2][1]);
        System.out.println(Arrays.toString(score[0])); 
        Arrays.toString(score[0]); //배열 내용 알기 위해 사용
        System.out.println();
        for(int i=0; i<4; i++){
            for(int j=0; j<2;j++){
               // System.out.println(score[i][j]);
                System.out.printf("score[%d][%d] : %.2f %n",i,j,score[i][j]);  //%.2f 소수점 2자리까지 출력
            }
        }
    }
}
