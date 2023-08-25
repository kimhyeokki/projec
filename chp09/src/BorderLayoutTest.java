import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutTest extends JFrame {
    public BorderLayoutTest(){
        setTitle("BorderLayout");
        setSize(500 , 500);
           setVisible(true);
           //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           Container container = getContentPane();

           container.add(new JButton("Calc"),BorderLayout.CENTER);  //BorderLayout은 공간 구역 나눌때
           container.add(new JButton("add"),BorderLayout.NORTH);
           container.add(new JButton("sub"),BorderLayout.SOUTH);
           container.add(new JButton("mul"),BorderLayout.EAST);
           container.add(new JButton("div"),BorderLayout.WEST);

    }
    public static void main(String[] args) {
        BorderLayoutTest layout = new BorderLayoutTest();

    }
    
}
