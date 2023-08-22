//6개의 char를 입력 받아 4,3,2,1 로 처리해서 평균 구하기

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Quiz02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Character ch[] = {'A','A','B','B','D','C'};
        ArrayList<Character> scoreList = new ArrayList<>(Arrays.asList(ch));
        Iterator<Character> it = scoreList.iterator();
        double score = 0.0;
        while(it.hasNext()){
           char ch02 =it.next();
                switch(ch02){
                case 'A':
                    score += 4.0;
                    break;
                case 'B':
                    score += 3.0;
                    break;
                case 'C':
                    score += 2.0;
                    break;
                case 'D':
                    score += 1.0;
                    break;
                case 'F':
                    score += 0.0;
                    break;
            }
        }
        // scoreList.add('A');
        // scoreList.add('A');
        // scoreList.add('B');
        // scoreList.add('B');
        // scoreList.add('D');
        // scoreList.add('C');
        // double score = 0.0;
        // for(int i =0;i<scoreList.size();i++){
        //     System.out.println(scoreList.get(i));
        //     char ch =scoreList.get(i);
        //     switch(ch){
        //         case 'A':
        //             score += 4.0;
        //             break;
        //         case 'B':
        //             score += 3.0;
        //             break;
        //         case 'C':
        //             score += 2.0;
        //             break;
        //         case 'D':
        //             score += 1.0;
        //             break;
        //         case 'F':
        //             score += 0.0;
        //             break;
        //     }
        // }
        System.out.println(score/scoreList.size());
        // HashMap<String,Integer> HashMap = new HashMap();
        // int sum =0;
        // for(int i=0;i<5;i++){
        //     HashMap.put(sc.next(), 4-i);
        // }
        // Set set = HashMap.keySet();
        // //   for(int i=0;i<5;i++){
        // //     sum += HashMap.get(sc.next());
             
        // // }
        // System.out.println();
    }
    
}
