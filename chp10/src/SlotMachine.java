import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SlotMachine extends JFrame {
    List<JLabel> labelList =new ArrayList<>();
    int nums[] = new int[3];
    Random ran = new Random();
    SlotMachine(){
        setTitle("슬롯 머신");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
        JLabel resultLabel = new JLabel();
        resultLabel.setSize(300, 50);
        resultLabel.setLocation(0, 150);
        resultLabel.setText("경기를 시작합니다");
        contentPane.add(resultLabel);
        for(int i =0;i<3;i++){
            JLabel label = new JLabel();
            label.setOpaque(true);
            label.setBackground(Color.RED);
            label.setForeground(Color.YELLOW);
            label.setFont(new Font("맑은 고딜", Font.ITALIC, 24));
            label.setSize(80, 50);
            label.setLocation(90*i+15, 100);
            label.setText("0");
            label.setHorizontalAlignment(JLabel.CENTER);
            contentPane.add(label);
            labelList.add(label);
        }
        contentPane.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    Set<Integer> set = new HashSet<>();
                    for(int i =0;i<labelList.size();i++){
                        int random = ran.nextInt(10);
                        labelList.get(i).setText(""+random);
                        set.add(random);
                    }
                    if(set.size()==1){
                        System.out.println("빙고");
                        resultLabel.setText("빙고");
                    }else{
                        resultLabel.setText("떙");
                    }
                }
            }
        });

        setSize(500, 500);
        setVisible(true);
        contentPane.setFocusable(true);
        contentPane.requestFocus();
    }
    public static void main(String[] args) {
        new SlotMachine();
    }
}
