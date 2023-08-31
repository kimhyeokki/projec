import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;

class ThreadLoop extends JPanel implements Runnable {   //ThreadLoop는 JPanel를 상속 받고 Runnable implements 한다.
private boolean isEnd = false;
public void setEnd(boolean isEnd) {
    this.isEnd = isEnd;
}
Random ran = new Random();
ThreadLoop(){
}

    @Override
    public void run() {
       while(true){
        JLabel label01 = new JLabel("JAVA");
        setLayout(null);
        add(label01);
        label01.setLocation(ran.nextInt(400), ran.nextInt(400));
        label01.setSize(100, 40); 
        repaint();
        try {
            Thread.sleep(10);
            if (isEnd) {
                removeAll();
                label01 = new JLabel("end");
                 add(label01);
                 label01.setForeground(Color.RED);
                label01.setLocation(130, 130);
                label01.setSize(100, 40); 
                repaint();
                return;            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
       }
    }

}

public class ThreadText extends JFrame  {
     Thread thread;
    ThreadText(){
     this.setTitle("Thread");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ThreadLoop loop = new ThreadLoop();
        this.setContentPane(loop);  //JPanel를 상속 받은 바로 컨테이너화 한다.
        loop.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                loop.setEnd(true);
              // thread.interrupt();
            }
        });
        thread = new Thread(loop);
        thread.start();
        this.setSize(450, 470);
        this.setVisible(true);
    }
        public static void main(String[] args) {
            new ThreadText();
        }
    }
