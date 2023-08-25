import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Quiz04 extends JFrame {
   List<JLabel> labellList = new ArrayList<>();
   Random ran = new Random();
   int nums[]= new int[3];
    Quiz04(){
        setTitle("슬롯 머신");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Container container = this.getContentPane();
        setSize(500, 500);
        container.setLayout(null);
        JLabel resultJLabel= new JLabel();
        resultJLabel.setSize(300, 50);
        resultJLabel.setLocation(0, 250);
        resultJLabel.setText("경기를 시작합니다");
        container.add(resultJLabel);
        for(int i=0;i<3;i++){
            JLabel label = new JLabel();
            label.setOpaque(true);
            label.setBackground(Color.RED);
            label.setBackground(Color.YELLOW);
            label.setSize(80, 50);
            label.setLocation(90*i+15, 100);
            label.setText("0");
            label.setHorizontalAlignment(JLabel.CENTER);
            container.add( label);
            labellList.add(label);
        }
        container.addKeyListener(new MyKeyAdapter(){
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    //System.out.println("enter");
                //    int ran02 = ran.nextInt(5);
                //    labellList.get(0).setText(""+ran02);
                //    int ran03 = ran.nextInt(5);
                //    labellList.get(1).setText(""+ran03);
                //    int ran04 = ran.nextInt(5);
                //    labellList.get(2).setText(""+ran04);
                   Set<Integer> set = new HashSet<>();
                   for(int i=0;i<labellList.size();i++){
                       int ran05 = ran.nextInt(5);
                       labellList.get(i).setText(""+ran05);
                       set.add(ran05);
                    }
                    if(set.size()==1){  //Set은 중복허용을 하지 않는다 그래서 모두 같은 값이면 Size() 1이 나온다.
                        System.out.println("빙고");
                        resultJLabel.setText("빙고");
                    } else{
                        resultJLabel.setText("경기를 시작합니다");
                    }
                }
            }
        });
        container.setFocusable(true); //키 이벤트를 받기위해
        container.requestFocus();
        
    }

    class MyKeyAdapter extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
        
        }
    }
    

    public static void main(String[] args) {
        new Quiz04();
    }
}
    