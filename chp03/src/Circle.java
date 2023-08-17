//반지름 
//pi

public class Circle {         
    //변수 선언
    int radius;
    String name;

    Circle() {  //생성자 함수를 여러개 만들 수 있다 이름은 같지만 매개변수를 활용해서(오버로드라고 한다.)
        radius=1;
        name="";
    }
    Circle(int radius){
        this.radius =radius;
    }
    Circle(int radius, String name) {
        this.radius = radius;
        this.name= name;
    }

    //함수 만들때  타입이 있어야 한다, sysout => 앞에 void // 리턴 값의 타입을 지정해줘야한다.
    double getArea(){
        return radius*radius*3.14;
    }

    public static void main(String[] args) {
         Circle pizza = new Circle();  //new를 활용해서 함수 호출, 
         pizza.radius =5;
         pizza.name ="원반";
        double pizzaArea = pizza.getArea();
         System.out.println(pizza.name + " 의 넓이는 " + pizzaArea); 

         Circle domino = new Circle(20, "도미노");
          domino.getArea();
          System.out.println(domino.name + " 의 넓이는 " + domino.getArea()); 

        Circle obj01 = new Circle(1);
        Circle obj02 = new Circle(2);
        Circle obj03;
        obj03 =obj02;
        obj01 =obj02;
        System.out.printf("obj01의 반지름은 ===%d %n",obj01.radius);
        System.out.printf("obj02의 반지름은 ===%d",obj02.radius);


        Circle circles[] =new Circle[5]; // 객체도 배열로 만들 수 있다. 
        for(int i=0;i<5;i++){
            circles[i] = new Circle((i+1)*10);
        }
        
        System.out.println(circles[0].radius);

        
        
    }
}
