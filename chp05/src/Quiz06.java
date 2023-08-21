////

import java.util.Arrays;
import java.util.Scanner;

public class Quiz06 {
    public static void main(String[] args) {
        int alpabets[] = new int[26];
        String str = "acxdx  bbbbbbbbbvad gfhtggga   f  j a g e r g nvckmvaiebg  vlkdmvaiotgb";
        System.out.println(str.length());
            for(int i=0;i<alpabets.length;i++){
                char ch = str.charAt(i);
                if((int)ch!=32){
                    alpabets[ch -'a']++;
                }
            }
                System.out.print(Arrays.toString(alpabets));

    }
}
