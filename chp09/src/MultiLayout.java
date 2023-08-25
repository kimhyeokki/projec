import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class NorthPanel extends JPanel{
    NorthPanel(){
        setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
        setOpaque(true);
        setBackground(Color.LIGHT_GRAY);
        add(new JButton("열기"));
        add(new JButton("닫기"));
        add(new JButton("나가기"));
    }
}
class SouthPanel extends JPanel{
    SouthPanel(){
         setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        setOpaque(true);
        setBackground(Color.LIGHT_GRAY);
        add(new JButton("Word Input"));
        add(new JTextField(15));
      

    }
}
public class MultiLayout extends JFrame{
    MultiLayout(){
        setTitle("Quiz02");
        setSize(800, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container =this.getContentPane();
        //container.setLayout(null);
       container.setLayout(new BorderLayout());
       container.add(new NorthPanel(),BorderLayout.NORTH);
       container.add(new SouthPanel(),BorderLayout.SOUTH);
      
       JPanel ceterPanel = new JPanel();
       container.add(ceterPanel,BorderLayout.CENTER);
       ceterPanel.setLayout(null);
       ceterPanel.setBackground(Color.YELLOW);
       ceterPanel.setOpaque(true);
        Random random = new Random();
        for(int i=0;i<20;i++){
            String num = i<10 ? "0"+i: ""+i;
            JLabel label = new JLabel(""+num);
            ceterPanel.add(label);
            //container.add(label);
            label.setOpaque(true);
            label.setLocation(50+random.nextInt(200),50+ random.nextInt(250));
            label.setSize(20, 20);
        }
    }

    public static void main(String[] args) {
        new MultiLayout();
    }
}
