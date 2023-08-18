

 class Point {
    private int x,y; //필드(속성) 생성

    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void show(){
        System.out.printf("(%d),(%d)",this.x,this.y);
    }

}
 