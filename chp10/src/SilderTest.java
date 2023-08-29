import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SilderTest extends JFrame {
    private JSlider jSliderList[] = new JSlider[3];
    private JLabel jLabel = new JLabel("컬러 체인지");
    SilderTest(){
        setTitle("");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane =this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        for(int i=0;i<3;i++){
           jSliderList[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
            contentPane.add(jSliderList[i]);
            jSliderList[i].setPaintLabels(true);
            jSliderList[i].setPaintTicks(true);
            jSliderList[i].setPaintTrack(true);
            jSliderList[i].setMajorTickSpacing(50); //50씩 간격
            jSliderList[i].setMinorTickSpacing(10); //50사이의 간격은 10단위로 
            jSliderList[i].addChangeListener(new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent e) {
                    int r = jSliderList[0].getValue();
                    int g = jSliderList[2].getValue();
                    int b = jSliderList[1].getValue();
                    jLabel.setBackground(new Color(r,g,b));
                    jLabel.setText("컬러 체인지 : "+r+","+g+","+b);
                }
                
            });
        }
        jSliderList[0].setForeground(Color.RED);
        jSliderList[1].setForeground(Color.BLUE);
        jSliderList[2].setForeground(Color.GREEN);

        contentPane.add(jLabel);
        jLabel.setBackground(Color.black);
        jLabel.setForeground(Color.WHITE);

        
        jLabel.setOpaque(true);
        setSize(300, 500);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SilderTest();
    }
}
