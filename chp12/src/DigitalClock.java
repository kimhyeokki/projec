import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

class Timerloop extends JLabel implements Runnable {
    private Thread thread;
    Timerloop(){
        thread = new Thread(this);
        thread.start(); 
    }
    public String showTimeTxt(){
        Calendar calendar = Calendar.getInstance();  // Calender 선언할 때 new를 활용하지 않고 Calendar.getInstance()
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int mins = calendar.get(Calendar.MINUTE);
        int secs = calendar.get(Calendar.SECOND);
          return hour+":"+mins+":"+secs;
    }
    @Override
    public void run() {
        int sec =0;
        int min =0;
      
        while(true){
            setText(showTimeTxt());
            // setText(":"+min+":"+sec);
            // sec++;
            // if(sec==60){
            //     sec=0;
            //     min++;
            //     setText(":"+min+":"+sec);
            // }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public class DigitalClock extends JFrame {
    //시계.. Calendar
    //Thread.sleep()
    //JLabel
    DigitalClock(){
        setTitle("시계");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        Timerloop timerloop = new Timerloop(); //위 클래스를 객체 선언
        contentPane.add(timerloop); //timerloop는 JLabel를 상속 받고 있어서 가능
        timerloop.setFont(new Font("맑은 고딕", Font.BOLD, 40));
        setSize(300, 300);
        setVisible(true);

    }
    public static void main(String[] args) {
        new DigitalClock();
    }
}
