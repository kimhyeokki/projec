import java.util.Scanner;

public class Month {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mon = scanner.nextInt();
        String season ="";
        switch(mon){
            case 0 : season= "가을";
            break;
            case 1,2,12 :season= "겨울";
            break;
            case 3,4,5 :season= "봄";
            break;
            case 6,7,8 :season= "여름";
            break;
            case 9,10 :season= "가을";
            break;
            default : season= "없는 달입니다.";
            break;
        }
        System.out.println(season);
        scanner.close();
    }
}
