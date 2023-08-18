public class ColorPointTest {
    public static void main(String[] args) {
        Point point = new Point();
        point.set(10, 20);
        point.show();

        ColorPoint colorPoint = new ColorPoint();
        colorPoint.set(100, 100);
        colorPoint.show();
        colorPoint.setcolor("blue");
        colorPoint.showColor();
    }
}
