import java.awt.Color;
import java.awt.Container;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Quiz02 extends JFrame {
    Quiz02(){
        setTitle("Quiz02");
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container =this.getContentPane();
        container.setLayout(null);
        Color colors[] ={Color.MAGENTA,Color.BLUE,Color.RED,Color.GREEN};
        Random random = new Random();
        

        for(int i=0;i<20;i++){
            String num = i<10 ? "0"+i: ""+i;
            JLabel label = new JLabel(""+num);
            label.setOpaque(true);
           label.setBackground(colors[random.nextInt(4)]);
                label.setLocation(50+random.nextInt(200),50+ random.nextInt(250));
         
            label.setSize(20, 20);
            container.add(label);
        }
        
    }
    public static void main(String[] args) {
        new Quiz02();
    }
}
