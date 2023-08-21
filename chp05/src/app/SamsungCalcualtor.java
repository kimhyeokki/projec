package app;

import com.Calcualtor;  // 다른 패키지에서 클래스를 가져오기 위해 작성해야함.

public class SamsungCalcualtor extends Calcualtor {

    @Override
    public int add(int a, int b) {
       return a+b;
    }

    @Override
    public int subtract(int a, int b) {
       return a-b;
    }

    @Override
    public double average(int[] array) {
        double sum = 0;
        for(int i=0; i<array.length;i++)
        {
            sum += array[i];
        }
        return sum/array.length;
    }

   
    
}
