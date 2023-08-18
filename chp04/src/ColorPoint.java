public class ColorPoint extends Point {  //ColorPoint란 클래스는 Point라는 부모 클래스에게 상속 받았습니다.(extends)
    private String color;

    public void setcolor(String color){
        this.color =color;
    }
    
    public void showColor(){
        System.out.printf("%n색상은 %s",color);
    }

     public static void main(String[] args) {
         ColorPoint colorPoint = new ColorPoint();
         colorPoint.set(0, 0);
         colorPoint.setcolor("Red");
         colorPoint.show();
         colorPoint.showColor();
     }
   

}
