import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GridLayotTest extends JFrame{
    GridLayotTest(){
        setTitle("GridLayoutTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setVisible(true);
        Container container = this.getContentPane();
      //  container.add(new JButton("Click"));
        container.add(new JLabel("이름"));
        container.add(new JTextField());
        container.add(new JLabel("학번"));
        container.add(new JTextField());
        container.add(new JLabel("학과"));
        container.add(new JTextField());
        container.add(new JLabel("과목"));
        container.add(new JTextField());
        GridLayout gridLayout = new GridLayout(4, 2);
        gridLayout.setVgap(100);
        container.setLayout(gridLayout);
    }
    public static void main(String[] args) {
        new GridLayotTest();
    }
}
