class Sample{
    public int a;
    private int b;
    int c;
    
    public void setB(int b) {
        this.b = b;
    }
    
    int getB(int b){
        return b;
    }
}

public class AsccesTest {
    
    public static void main(String[] args) {
        Sample sample = new Sample();
        sample.a=10;
        sample.c=20;
        sample.getB(5);

    }
}
