import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DreamCar extends JFrame {
    private int num =2;
    DreamCar(){
        String carImgList[] ={
            "car01.png",
            "car02.png",
            "car03.png",
            "car04.png",
            "car05.png",
            "car06.png",
            "car07.png",
            "car08.png",
            "car09.png",
            "car10.png",
            "car11.png",
            "car12.png",
            "car13.png",
            "car14.png",
            "car15.png",
            "car16.png",
        };
         String carTitleList[] ={
            "벤츠",
            "람보르기니",
            "부가티",
            "BMW",
            "아우디",
            "소나타",
            "모닝",
            "그랜져",
            "페라리",
            "제네시스",
            "코란도",
            "폭스바겐",
            "모닝",
            "ㄹㅇㄹ",
            "ㄹㅇㄹㅇ",
            "ㅂㅈㄷㅂㅈㄷ",
        };
        this.setTitle("DreamCar");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        JLabel label = new JLabel("당신이 꿈꾸는 드림카 원하는 차를 클릭해주세요");
        label.setHorizontalAlignment(JLabel.CENTER);// JLabel의  가운데 정렬
        contentPane.setLayout(new BorderLayout());
        contentPane.add(label, BorderLayout.NORTH);
        label.setFont(new Font("맑은 고딕", Font.BOLD, 24));
        
        JPanel mainpanel = new JPanel();
        
        JPanel leftJPanel = new JPanel(new BorderLayout());
        ImageIcon imageIcon = new ImageIcon("image/car/car01.png");//ImageIcon을 생성해서 JLabel을 넣을 수 있다
        JLabel label02 = new JLabel(imageIcon);
        JLabel labelTxt02 = new JLabel("람보르기니");
        leftJPanel.add(label02, BorderLayout.NORTH);
        leftJPanel.add(labelTxt02, BorderLayout.SOUTH);
        mainpanel.add(leftJPanel);
        contentPane.add(mainpanel , BorderLayout.CENTER);
        
        JPanel rightJPanel = new JPanel(new BorderLayout());
        ImageIcon imageIcon01 = new ImageIcon("image/car/car02.png");//ImageIcon을 생성해서 JLabel을 넣을 수 있다
        JLabel label03 = new JLabel(imageIcon01);
        JLabel labelTxt03 = new JLabel("페라리");
        rightJPanel.add(label03, BorderLayout.NORTH);
        rightJPanel.add(labelTxt03, BorderLayout.SOUTH);
        mainpanel.add(rightJPanel);

        label02.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                label03.setIcon(new ImageIcon("image/car/"+carImgList[num]));
                labelTxt03.setText(carTitleList[num]);
                num++;
                if(num>=16){
                    rightJPanel.setVisible(false);
                    label.setText("당신의 드림카는"+labelTxt02.getText());
                   // label02.setEnabled(false);
                   label02.removeMouseListener(this);
                }

            }   
        });
        label03.addMouseListener(new MouseAdapter() {
              public void mouseClicked(MouseEvent e) {
                label02.setIcon(new ImageIcon("image/car/"+carImgList[num]));
                labelTxt02.setText(carTitleList[num]);
                num++;
                 if(num>=16){
                    leftJPanel.setVisible(false);
                      label.setText("당신의 드림카는"+labelTxt03.getText());
                   // label02.setEnabled(false);
                   label03.removeMouseListener(this);
                }
            }   
        });

        
        this.setVisible(true);
        this.setSize(800, 600);
    }
    public static void main(String[] args) {
        new DreamCar();
    }
}
