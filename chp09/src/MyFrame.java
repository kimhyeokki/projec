import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame(){
        //-------------------------------------------// 기본적으로 만들어야함
        setTitle("300 x 300 으로 만든 프레임");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //--------------------------------------------//
        Container container = this.getContentPane(); // JFrame이 기본으로 가지고있는 Container JPanel
        //Container 생략가능->
        //setLayout(new FlowLayout());
        //add(new JButton("OK"));
        //add(new JButton("Cancel"));
        container.setLayout(new FlowLayout());
        container.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 100));
        JButton btn =new JButton("OK");
        btn.addActionListener(new MyActionListener());
        container.add(btn);
        JButton btn02 = new JButton("Cancel");
        btn02.addActionListener(new MyActionListener());
        container.add(btn02);
        //최상위 container panel (button)

    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();    
    }
}
