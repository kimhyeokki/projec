class MyPoint {
    int x,y;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "Point("+x+","+y+")";

    }
    public boolean equals(Object object){
        MyPoint point =(MyPoint) object;
        if(x==point.x && y==point.y) return true;
        else return false;
    }
}

public class Quiz01 {
    //x,y, 속성으로 가지는 Mypoint 객체를 만들고
    //toString()을 오버라이드 해서 point(3,4)가 출력되게 하시오
    // equals()를 오버라이드 해서 
    // 두 점의 좌표가 같으면 true 아니면 false 리턴하도록 하자
    public static void main(String[] args) {
        MyPoint point = new MyPoint(3, 4);
        MyPoint point02 = new MyPoint(3, 4);
        System.out.println(point.toString());
        if(point.equals(point02)){
            System.out.println("같다");
        }
    }
    
}
