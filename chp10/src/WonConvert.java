import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WonConvert extends JFrame {
    private JLabel label[] = new JLabel[9];
    private JTextField textField[] = new JTextField[9];
    private String num[] = {
        "오만원",
        "만원",
        "오천원",
        "천원",
        "500원",
        "100원",
        "50원",
        "10원",
        "1원",
    };
    WonConvert(){
        setTitle("TextFiled test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        JLabel titleLabel = new JLabel("금액");
        JTextField wonLabel = new JTextField(20);
        JButton btn = new JButton("계산");
        titleLabel.setBounds(100, 100, 120, 30);
        wonLabel.setBounds(150, 100, 120, 30);
        btn.setBounds(300  , 100, 100,  30);
        contentPane.add(titleLabel);
        contentPane.add(wonLabel);
        contentPane.add(btn);
        JPanel maiPanel = new JPanel();
       contentPane.add(maiPanel);
       contentPane.setLayout(null);

        for(int i=0;i<9;i++){
            label[i] = new JLabel(num[i]);
            label[i].setBounds(100, 150+30*i, 120, 30);
            textField[i] = new JTextField(10);
            textField[i].setBounds(150, 150+30*i, 120, 30);
            contentPane.add(label[i]);
            contentPane.add(textField[i]);
            
        }
        
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
             int nums =  Integer.valueOf(wonLabel.getText());
            System.out.println(nums);
            int won[] ={
            nums/50000,
            nums%50000/10000,
            nums%10000/5000,
            nums%5000/1000,
            nums%1000/500,
            nums%500/100,
            nums%100/50,
            nums%50/10,
            nums%10/1,
            };
            for(int i = 0; i<9;i++){
                textField[i].setText(""+won[i]);
              }
            }
            
        });
        setSize(500, 500);
        setVisible(true);
    }
    public static void main(String[] args) {
        new WonConvert();
    }
}
