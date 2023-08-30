import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
//1. 스레드를 상속받아 처리
//2. 스레드를 im
import javax.swing.JLabel;

class TimerTest implements Runnable {    //implements가 유용한 이유 extends 중복이 불가함
    private JLabel timerLabel;
    TimerTest(JLabel timerLabel){
        this.timerLabel = timerLabel;
    }
    @Override
    public void run() {
        int num=0;
        while(true){
            timerLabel.setText(""+num);
            num++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
} 

public class TimerRannable extends JFrame{ 
    TimerRannable(){
        this.setTitle("Thread");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        JLabel label = new JLabel("ffff");
        label.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        contentPane.add(label);
        TimerTest timerTest = new TimerTest(label); //위 클래스의 객체 선언
        Thread thread = new Thread(timerTest); // implemets 한 timerTest를 쓰레드 활용하기 위해 객체 선언
        thread.start();
        this.setSize(400, 400);
        this.setVisible(true);

    }


    public static void main(String[] args) {
        new TimerRannable();
    }
}