import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ComponentTest extends JFrame {
    ComponentTest(){
        this.setTitle("컴퍼넌트 테스트");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        JButton btn01 = new JButton("Red/Yellow");
        JButton btn02 = new JButton("disable");
        JButton btn03 = new JButton("x,y");
        btn01.setForeground(new Color(255,0,0));  //글자 색갈
        btn02.setBackground(new Color(255,255,0));
        btn02.setEnabled(false);
        btn01.setFont(new Font("맑은 고딕", Font.BOLD, 30));

        contentPane.add(btn01);
        contentPane.add(btn02);
        contentPane.add(btn03);

        btn03.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton)e.getSource();
                ComponentTest frame = (ComponentTest)btn.getTopLevelAncestor();
                frame.setTitle(btn03.getX()+"/"+btn03.getY());
            }
            
        });

        this.setSize(500, 500);
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new ComponentTest();
    }    
}
