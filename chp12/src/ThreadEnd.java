import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
class TimerRannable02 implements Runnable{
    private JLabel timerLabel;
    private boolean isEnd = false;
    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    TimerRannable02(JLabel timerLabel){
        this.timerLabel = timerLabel;
        
    }

    @Override
    public void run() {
        int num=0;
        while (true) {
            timerLabel.setText(""+num);
            num++;
            try {
                Thread.sleep(100);
                if(isEnd){                    //조건을 걸어서 try문에서도 종료 가능하다.
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;  //Thread 종료지점 interrupt()을 통해 예외처리된 catch로 오고 여기서 return하면 종료..
            }
        }
    }

}

public class ThreadEnd extends JFrame {
    Thread thread;
    ThreadEnd(){
        this.setTitle("Thread");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        JLabel label = new JLabel();
        TimerRannable02 time = new TimerRannable02(label);
        JButton btn = new JButton("STOP");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("클릭");
               //thread.interrupt(); //Thread를 종료하기 위해 예외발생시키는 메서드,
                                    //Interupt가 발생한 쓰레드는 예외를 catch하여 다른 작업을 할 수 있음
                time.setEnd(true);
            }
            
        });
        thread = new Thread(time);
        thread.start();
        contentPane.add(label);
        contentPane.add(btn);
        this.setSize(400, 400);
        this.setVisible(true);
    }   
    
    public static void main(String[] args) {
        new ThreadEnd();
    }
}
