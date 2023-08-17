public class Rectangle {
    //wiidth height 라는 변수를 가지고
    // int getArea
    int width;
    int height; 
    Rectangle(){  // 생성자 함수 언제?실행되냐 메모리에 올라 올때 실행
        System.out.println("호출합니다!");
    }
    int getArea(){
        return width*height;
    }

    public static void main(String[] args) {
        Rectangle name = new Rectangle();  //Rectangle 이라는 클래스를  new를 활용해서 호출합니다.
        name.height = 10;
        name.width = 20;
        int ww = name.getArea();

        System.out.println(ww);

    }

}
