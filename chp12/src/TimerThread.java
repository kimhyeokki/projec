import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
//1. 스레드를 상속받아 처리
//2. 스레드를 implement Runnable 
import javax.swing.JLabel;

class TimerTest extends Thread {
    private JLabel timerLabel;     //Jlabel 선언
    TimerTest(JLabel timerLabel){    //생성자 만들고
        this.timerLabel = timerLabel;
    }
    @Override
    public void run() {            
        int num=0;
        while(true){
            timerLabel.setText(""+num);
            num++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
} 

public class TimerThread extends JFrame{ 
    TimerThread(){
        this.setTitle("Thread");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        JLabel label = new JLabel("ffff");
        label.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        contentPane.add(label);
        TimerTest timerTest = new TimerTest(label);  //위클래스의 객체 선언 
        timerTest.start();  //쓸수 있는 이유 TimerTest는 Thread를 상속 받고 있기 때문
        this.setSize(400, 400);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        new TimerThread();
    }
}