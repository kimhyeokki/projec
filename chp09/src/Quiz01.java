import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Quiz01 extends JFrame {
    Quiz01(){
        setTitle("TEST");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(300, 300);
        Container container =this.getContentPane();
        Color colors[] ={Color.MAGENTA,Color.BLUE,Color.RED,Color.GREEN};
        Random random = new Random();
        for(int i =0;i<16;i++){
            String num = i<10 ? "0"+i:""+i   ;     
            JLabel label = new JLabel("label"+num);
            label.setBackground(colors[random.nextInt(4)]);
            label.setOpaque(true);
            container.add(label);
        }
        GridLayout gridLayout = new GridLayout(4,4);
        //gridLayout.setVgap(100);
        container.setLayout(gridLayout);
    }
    public static void main(String[] args) {
        new Quiz01();
    }
}
//20개의 label을 만들어서 300,300에 랜덤하게 뿌려보세요
//Color 4개 만들어서 랜덤하게
// 50~250 사이에
