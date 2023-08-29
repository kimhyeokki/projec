import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JComboBoxTest extends JFrame{
    private String fruits [] = {"apple","plum","strawberry"};
    private ImageIcon imageList[] = {
        new ImageIcon("image/apple.png"),
        new ImageIcon("image/plum.png"),
        new ImageIcon("image/strawberry.png")
    };
    private JLabel imgLabel = new JLabel(imageList[0]);
    JComboBoxTest(){
         setTitle("");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane =this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        JComboBox<String> jComboBox = new JComboBox<>(fruits);
        contentPane.add(jComboBox);
        contentPane.add(imgLabel);
        jComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("바겼다");
                System.out.println(jComboBox.getSelectedIndex());
                System.out.println(jComboBox.getSelectedItem());
                imgLabel.setIcon(imageList[jComboBox.getSelectedIndex()]);
            }
        });
        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JComboBoxTest();
    }
}
