class Circle {
    int x,y,radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public String toString(){
        return "Circle("+x+","+y+") 반지름은 "+radius;
    }

    public boolean equals(Object object){
        Circle circle = (Circle)object;
        if(x==circle.x && y==circle.y) return true;
        else return false;
    }
    
}

public class Quiz02 {
    //x,y, radius를 가지는 circle 객체를  만들고
    //toString()을 오버라이드 해서 Circle(3,4), 반지름 10이 출력되게 하시오
    // equals()를 오버라이드 해서 
    // 두 점의 좌표가 같으면 true 아니면 false 리턴하도록 하자
    public static void main(String[] args) {
        Circle circle = new Circle(3, 4, 10);
        Circle circle02 = new Circle(3, 4, 10);
        System.out.println(circle.toString());
        if(circle.equals(circle02))
        System.out.println("true");
    }
}
