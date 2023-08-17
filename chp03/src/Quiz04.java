class MyCircle{
    double x;
    double y;
    int radius;
    public MyCircle(double x, double y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    double getArea(){
        return  radius*radius*Math.PI;
    }
    void show(){
        System.out.printf("x는 %.2f %ny는 %.2f %n반지름은 %d%n면적은 %.2f",this.x,this.y,this.radius,getArea());
    }
}

public class Quiz04 {
    //int intArray[] = new int[3]
    // MyCircle 클래스 만들고, 맴버필드로는 double x,y, int radius를 가짐
    //생성자 함수는 매개변수 x,y,radius를 갖는다 
    // 정보를 출력하는 show() 매서드를 만들고 x,y 면적이 출력
    //면적을 출력하는 함수
    public static void main(String[] args) {
        MyCircle mycircle01[] = new MyCircle[3];
      // 3개의  mycircle01  배열 생성
        for(int i=0;i<3;i++){
              double x= Math.random()*200 +100;
              double y= Math.random()*200 +100;
               int radius =(int)(Math.random()*40 +10);
                mycircle01[i] = new MyCircle(x, y, radius); 
        }
        //mycircle01[0], [1], [2] 대한 값 부여함 반복문을 통해서
        mycircle01[0].show();
        mycircle01[1].show();
        mycircle01[2].show();
        int big =0;
        for(int i=0;i<mycircle01.length;i++){
            if(mycircle01[i].getArea() >mycircle01[big].getArea()){
                big=i;
            }
        }
        //3개 중 가장 큰 면적을 찾기위해서 [0].getArea,[1].getArea,[2].getArea 비교
        mycircle01[big].show();
    }
}
