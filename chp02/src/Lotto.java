import java.util.Arrays;

public class Lotto {
    public static void main(String[] args) {
        //번호 여섯개 뽑기
        // 1~45
        // 0<Math.random()<1
        //  0<Math.random()*45<45
         int nums[] =new int[45];
        for(int i=0; i<nums.length;i++){
            nums[i] = i +1;
        }
        Arrays.toString(nums);
        System.out.println( Arrays.toString(nums));
        Math.floor(Math.random()*45);
        System.out.println(Math.floor(Math.random()*45));
        
        
        
        for(int j=0; j<100;j++){ //100
          int selected =(int)(Math.random()*nums.length);
          int temp = nums[0];
          nums[0] =nums[selected];
          nums[selected] = temp;

        }

        int lotto[] = Arrays.copyOf(nums, 6); //Array.copyof(배열이름, 길이) 배열에서 6개만 뽑아서 새로 배열 만든다
       System.out.println( Arrays.toString(lotto));
        Arrays.sort(lotto);   // 배열 정렬
         System.out.println( Arrays.toString(lotto));
    
        for(int k=0;k<6;k++){
           System.out.println(lotto[k]);
          
        }
        

    }
}
