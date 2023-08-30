import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

class FilckTest extends JLabel implements Runnable{
    private long delay;
    FilckTest(String msg, long delay){
        super(msg);  // super() 는 부모 클래스 호출한다.(즉 상속 받은 JLabl에서 호출한다.) ==JLable(String msg)
        this.delay = delay;
        this.setForeground(Color.WHITE);
        this.setOpaque(true);
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
       int num =0;
        while (true) {
            if(num ==0){
                this.setBackground(Color.RED);
                num=1;
            }else{
                this.setBackground(Color.BLUE);
                num=0;
            }
        try {
            Thread.sleep(delay); 
        } catch (InterruptedException e) {
        }

       }
    }
}

public class FilckTestApp extends JFrame {
    FilckTestApp(){
       this.setTitle("Thread");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        FilckTest filckTest = new FilckTest("Flicks", 100); //JLabel를 상속 받은 클래스
        FilckTest filckTest02 = new FilckTest("깜빡 깜빡", 200);
        contentPane.add(filckTest);
        contentPane.add(filckTest02);
        // Thread thread = new Thread(filckTest);
        // thread.start();
        // Thread thread02 = new Thread(filckTest02);
        // thread02.start();
        this.setSize(400, 400);
        this.setVisible(true);
    }
        public static void main(String[] args) {
            new FilckTestApp();
        }
    }