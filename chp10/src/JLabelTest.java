import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JLabelTest extends JFrame {
    JLabelTest(){
        this.setTitle("JLabel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imageIcon = new ImageIcon("image/apple.png");
        JLabel label01 = new JLabel("gloomy monday");
        JLabel label02 = new JLabel(imageIcon);
        JLabel label03 = new JLabel("apple label", imageIcon, SwingConstants.RIGHT); //SwingConstants 위치바꿈
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(label01);
        contentPane.add(label02);
        contentPane.add(label03);
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JLabelTest();
        
    }
}
