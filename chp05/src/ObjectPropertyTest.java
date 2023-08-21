class Point {
    private int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "나는 "+x+","+y+" 입니다.";  //  문자열이지만 +int+ 해서 사용가능( chp04 예제 2번째 문제(Student01) 궁금점 확인요망)
    }                                       //오버라이딩해서 임의로 재정의 가능함
    public boolean equals(Object object){
        Point point = (Point)object;        //형 타입 변환 Object를 Point 형변환
        if(x ==point.x && y==point.y){
            return true;
        } else{
            return false;
        }
    }                                      // equals 을 재정의함
    
}

public class ObjectPropertyTest {
    public static void main(String[] args) {
        Point point = new Point(10, 10);
        Point point02 = new Point(10, 10);
    //    point02 =point;  // 이러면 해시코드가 같아지고, 메모리 위치가 같아짐
        System.out.println(point.getClass().getName()); //클래스의 이름을 알수 있으
        System.out.println(point.hashCode());           //해시코드? 잘모름겠음
        System.out.println(point02.hashCode());
        System.out.println(point.toString());  // toString() 클래스를 문자화 시킨다.
        System.out.println(point02.toString());  
        System.out.println(point.equals(point02));  //결과값은 같지만 메모리를 다르게 정의하면 다르다.
    
    }
}
