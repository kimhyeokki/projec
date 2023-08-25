import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AnonymousListener extends JFrame {
    AnonymousListener(){  
    setTitle("AnonymousListener");
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container =this.getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        JButton btn = new JButton("난 버튼");
        container.add( btn);
        btn.addActionListener(new ActionListener() {  //익명클래스
            @Override
            public void actionPerformed(ActionEvent e) {
               JButton btn01 = (JButton) e.getSource();
                btn01.setText("Let's go piknic");
            }
    
        });

    }
    public static void main(String[] args) {
        new AnonymousListener();
    }
}
