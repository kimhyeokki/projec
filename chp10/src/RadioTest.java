import java.awt.Checkbox;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class RadioTest extends JFrame {
    private JRadioButton radioList[] = new JRadioButton[3];
    private JLabel labelList[] = new JLabel[3];
    private JLabel sumLabel = new JLabel();
    private String imageList[] = {"image/apple.png","image/strawberry.png","image/plum.png"};
    private int priceList[] = {3000, 5000, 7000};
    private int sum =0;
    RadioTest(){
        setTitle("Radio box test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        ButtonGroup buttonGroup = new ButtonGroup();
        contentPane.add(sumLabel);
        sumLabel.setText("현재 가격은 0원입니다");
        ImageIcon imageIcon = new ImageIcon("image/apple.png");
        JCheckBox jCheckBox = new JCheckBox("사과",imageIcon,true);  //체크되어서 나타난다.
        // ImageIcon strawberryIcon = new ImageIcon("image/strawberry.png");
        // JCheckBox strawCheckBox = new JCheckBox("딸기", strawberryIcon, false);
        // strawCheckBox.setSelectedIcon(imageIcon02); 
        // strawCheckBox.setBorderPainted(true);  //테두리
        // contentPane.add(strawCheckBox);
        for(int i=0;i<3;i++){
            labelList[i] =new JLabel(""+priceList[i]);
            radioList[i] = new JRadioButton("",new ImageIcon(imageList[i]));
            radioList[i].setBorderPainted(true);
            buttonGroup.add(radioList[i]);
            contentPane.add(radioList[i]);
            contentPane.add(labelList[i]);
           radioList[i].addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {
                    if(e.getStateChange()==ItemEvent.SELECTED){
                        if(e.getItem()==radioList[0]){
                            System.out.println("사과");
                            sum +=3000;
                            //System.out.println(sum);
                        }else if(e.getItem()==radioList[1]){
                            System.out.println("딸기");
                            sum +=5000;
                            
                        } else{
                            sum +=7000;
                        }
                    }else if(e.getStateChange()==ItemEvent.DESELECTED){
                         if(e.getItem()==radioList[0]){
                            System.out.println("사과");
                            sum -=3000;
                            //System.out.println(sum);
                        }else if(e.getItem()==radioList[1]){
                            System.out.println("딸기");
                            sum -=5000;
                            
                        } else{
                            sum -=7000;
                        }
                    }
                    sumLabel.setText("현재 가격은 "+sum+"원입니다");
                }
                
            });
           
        }
        
        // jCheckBox.setSelectedIcon(imageIcon02); 
        // jCheckBox.setBorderPainted(true);  //테두리
        // contentPane.add(appleLabel);
        // contentPane.add(jCheckBox);

        jCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange()==ItemEvent.SELECTED){
                    System.out.println("선택되었습니다.");
                }else{
                    System.out.println("해제되었습니다.");
                }
            }
        });
        setSize(500, 500);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new RadioTest();
    }
}
