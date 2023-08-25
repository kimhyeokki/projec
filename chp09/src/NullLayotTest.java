import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NullLayotTest extends JFrame{
    NullLayotTest(){
        setTitle("NullLayoutTest");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        container.setLayout(null); //자유로운 배치를 위해
        JLabel label = new JLabel("0");
        container.add(label);
        label.setLocation(0, 0);
        label.setBackground(Color.green);
        label.setSize(100, 40);
        label.setLayout(null);
//---------------------------------------------------------------------//

        JPanel btnPanel = new JPanel();  //묶어서 한번에 위치시키기 위해서
        container.add(btnPanel);         //contentPane() 에 Panel 추가
        btnPanel.setLocation(100, 200);
        btnPanel.setSize(500, 400);
        btnPanel.setLayout(null);   // 내가 직접 위치 지정을 위해 Null 값을 준다.

        for(int i=0;i<9;i++){
            JButton btn01 = new JButton("btn0"+i);
            btnPanel.add(btn01);       //JButton을 JPanel에 담는다. -> 즉 Panel에 이동에 따라 같이 움직입니다.
            //container.add(btn01);
            btn01.setBackground(Color.RED); //색갈지정
            btn01.setLocation(200+(i%3)*100, 35*(int)(i/3));
            btn01.setSize(100, 30);
        }
        setVisible(true);
        setSize(500, 500);

    }
    public static void main(String[] args) {
        new NullLayotTest();
    }
}
