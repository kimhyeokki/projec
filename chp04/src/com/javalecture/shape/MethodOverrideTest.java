package com.javalecture.shape;

class Shape{
    public void draw(){
        System.out.println("shape");
    }
}

class Line extends Shape {
    
    public void draw(){
        System.out.println("Line");   //오버라이트는 부모 클래스의 함수를 재정의 하는 것을 의미
                                        // ★오버라이트의 조건 
                                        // - 메서드의 선언부는 동일해야 한다. 
                                        // - 리턴값, 메소드명, 매개변수가 동일
                                        // - 구현부만 다르게 작성
    }
}
class Rect extends Shape{
    public void draw(){
        System.out.println("Rect");
    }
}
class Weapon {
    int fire(){
        return 1;
    }

}

class Canon extends Weapon{
    int fire(){
        return 10;
    }
}

public class MethodOverrideTest {
    public static void main(String[] args) {
        new Shape().draw();
        new Line().draw();
        new Rect().draw();
        Shape line = new Line(); // 라인이 shape으로 업스케일
        line.draw();
        //------------------------------------//
        Weapon weapon;
        weapon = new Weapon();
        weapon.fire();
        System.out.println("기본무기의 파워는 " +weapon.fire());
        
        weapon = new Canon();
        System.out.println("캐논의 파워는 " +weapon.fire());


        
    }
}
