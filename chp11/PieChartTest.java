import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PieChartTest extends JFrame {
    private JTextField nameList[] = new JTextField[4];
    private JLabel label[] = new JLabel[4];
    private String fruits[] ={"apple","cherry","strawberry","prune"};
    private Color colorList[] ={Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW};
    private int dataList[] ={0,0,0,0};
    private Chartpanel chartpanel =new Chartpanel();
    private int angleList[] = new int[4]; 

    PieChartTest(){
        this.setTitle("파이 차트 그리기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel upPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        upPanel.setBackground(Color.GRAY);
        upPanel.setOpaque(true);
        JPanel piePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(new InputPanel(),BorderLayout.NORTH);
        contentPane.add(chartpanel,BorderLayout.CENTER);

        setSize(800, 500);
        setVisible(true);

    }
    class MyActionListener implements ActionListener{
         @Override
                public void actionPerformed(ActionEvent e) {
                    JTextField textField =(JTextField) e.getSource(); 
                    int total=0;
                    int num =0;
                    try {
                        num = Integer.parseInt( textField.getText());
                    } catch (NumberFormatException ex) {
                        textField.setText("0");
                    }

                for(int i=0;i<4;i++){
                    dataList[i]= Integer.parseInt(nameList[i].getText());
                    total += dataList[i];
                    }
                     for(int i=0;i<4;i++){
                        angleList[i] = (int) Math.round(360*((double)dataList[i]/(double)total));
                     }
                     chartpanel.repaint();
                }
    }

    class InputPanel extends JPanel{
        InputPanel(){
            setLayout(new FlowLayout(FlowLayout.CENTER));
 for(int i=0;i<4;i++){
            label[i] =new JLabel(fruits[i]);
            nameList[i] = new JTextField(10);
            nameList[i].addActionListener(new MyActionListener());
            add(label[i]);
            add(nameList[i]);
 }
        }
    }

    class Chartpanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponents(getGraphics());
            int startAngle =0;
           
            for(int i=0;i<4;i++){
              //  int angle = (int) Math.round(360*((double)dataList[i]/(double)total));
                g.setColor(colorList[i]);
                g.fillArc(250, 150, 200, 200, startAngle,angleList[i]);
                startAngle += angleList[i];
            }
            // g.setColor(Color.BLUE);
            // g.fillArc(250, 150, 200, 200, 90, 90);
            // g.setColor(Color.GREEN);
            // g.fillArc(250, 150, 200, 200, 180, 90);
            // g.setColor(Color.YELLOW);
            // g.fillArc(250, 150, 200, 200, 270, 90);
        }
    }
    public static void main(String[] args) {
        new PieChartTest();
    }
}
