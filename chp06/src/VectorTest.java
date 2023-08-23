import java.util.Vector;
class Point {
    private int x,y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "Point [x="+x+",y="+y+"]";
    }
}

public class VectorTest {
    public static void main(String[] args) {
        //List(순서가 있고 중복 허용) , Set(순서가 없고 중복 x), map(키, Value) ex) Map<String, Integer> , 키는 중복 불가,값은 중복 가능
        Vector<Integer> vec = new Vector<>();
        vec.add(100);
        vec.add(200);
        vec.add(300);
        System.out.println(vec.get(2));
        for(int i=0;i<vec.size();i++){
            System.out.println(vec.get(i));
        }
        for(int i:vec){
            System.out.println(i);
        }
        //Quiz02 
        String animals = "호랑이,사자,토끼,거북이";
        //animails를 쪼개서 StringVec에 넣고 싶다
        Vector<String> stringvec = new Vector<>();
        String array[] = animals.split(",");
        for(int i=0;i<array.length;i++){
            stringvec.add(array[i]);
        }
        stringvec.add("캥거루");
        stringvec.add("캥거루");
        stringvec.remove(stringvec.size() -1);
        for(int i =0;i< stringvec.size();i++){
            System.out.println(stringvec.get(i));
        }
        System.out.println(stringvec.capacity());  //미리 선점하고 있는 숫자 ex) 10, 20... 10단위로 증가
        System.out.println(stringvec.size()); //갯수

        Vector<Point> pointvec = new Vector<>();
        pointvec.add(new Point(10, 10));
        pointvec.add(new Point(20, 20));
        pointvec.add(new Point(30, 30));
        Point point01 = pointvec.get(0);
        System.out.println(pointvec.get(0).toString());
    }
}
