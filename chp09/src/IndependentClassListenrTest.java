import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
//ActionListener 는 인터페이스
class MyActionListener implements ActionListener   {
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        e.getModifiers();
        JButton btn01 = (JButton) e.getSource();
        btn01.setText("I am Button");
        JButton btn02 = (JButton) e.getSource();
        btn02.setText("I am Back");
    }
}

public class IndependentClassListenrTest extends JFrame {
    IndependentClassListenrTest(){
        setTitle("IndependentClass");
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container =this.getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        JButton btn = new JButton("난 버튼");
        container.add( btn);
        btn.addActionListener(new MyActionListener());

    }

    public static void main(String[] args) {
        new IndependentClassListenrTest();
    }
}
