class Tv {
    private String brand;
    private int year;
    private int size;
    public Tv(String brand, int year, int size){
        this.brand =brand;
        this.year = year;
        this.size =size;
    }
    public void show(){
        System.out.println(this.brand + "에서 만든 " +this.year+"년형,"+this.size+"인치 tv입니다");
    }
}

public class Quiz01 {
    //TV 클래스 만들기
    //brand, year, size 필드 구성, 생성자 함수는 매개변수 3개 가질수 있도록 하자
    public static void main(String[] args) {
        
        Tv tv = new Tv("삼성", 19, 32);
        tv.show();;
    }
}
