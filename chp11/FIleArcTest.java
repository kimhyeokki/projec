import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class FIleArcTest extends JFrame {
    MyPanel myPanel = new MyPanel();

    class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.drawRect(100, 100, 100, 100);
            g.setColor(Color.RED);
            g.fillRect(150, 150, 100, 100);
            g.setColor(Color.BLACK);
           // g.fillOval(10, 10, 100, 100);

            g.fillArc(50, 50, 120, 200, 0,180);  
        }
    }
    FIleArcTest(){
        setTitle("Graphics");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(myPanel);
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FIleArcTest();
    }
}
