class Rect{
    private int width;
    private int height;
    public Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean equals(Object object){  //면적이 같으면 같다라고 재정의 함
        Rect rect =  (Rect)object; //입력한 값을 Rect로 형변환
        if(width*height==rect.width*rect.height) return true;
        else return false;
    }

}

public class RcetTest {
    public static void main(String[] args) {
        Rect rect01 = new Rect(10, 10);
        Rect rect02 = new Rect(20, 5);
        System.out.println(rect01.equals(rect02));
    }
}
