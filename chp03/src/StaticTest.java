class Calc{
    static int abs(int a){
        // if(a>0) return a;
        // else return -a;
        return a>0? a : -a;
    }
    static int max(int a, int b){
        return a>b? a: b;
    }
    static int min(int a, int b){
        return a>b? b: a;
    }
}

public class StaticTest {
    public static void main(String[] args) {
        //new Calc(); 생략
        Calc.abs(-10);              // static을 사용하면 main 클래스에서 new를 활용해서 함수 호출 하지 않고 
                                     //바로 클래스이름을 이용하여 사용가능
    }
}
