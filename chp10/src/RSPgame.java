import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.util.Random;


public class RSPgame extends JFrame {
    private JButton btnList[] = new JButton[3];  //3가지의 버튼을 만들기위해 선언
  ImageIcon abc = new ImageIcon("image/paper.png");
    Image originImage = abc.getImage();
    Image resizImage = originImage.getScaledInstance(70, 65, Image.SCALE_SMOOTH);
    private ImageIcon imageList[] ={
        new ImageIcon("image/rock.png"),
        new ImageIcon("image/scissors.png"),
        new ImageIcon(resizImage)
};
    Random random = new Random();
    JPanel panel01 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel panel02 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    RSPgame(){
        setTitle("가위바위보");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane =this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        JLabel label = new JLabel();
        JLabel comLabel =new JLabel();
        JLabel resultLabel =new JLabel();
        contentPane.add(panel01,BorderLayout.NORTH);    
        contentPane.add(panel02,BorderLayout.CENTER);    
        for(int i=0;i<3;i++){
            btnList[i] =new JButton(imageList[i]);
            panel01.add(btnList[i]);
            int meselect = i;

            btnList[i].addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                       label.setIcon(btnList[meselect].getIcon());
                       label.setText("Player");
                       int ran = random.nextInt(3);
                       comLabel.setIcon(btnList[ran].getIcon());
                       comLabel.setText("컴퓨터");
                       if(ran == meselect){
                            resultLabel.setText("비겼습니다.");
                       }else if((meselect==0 && ran==1) || (meselect==1 && ran==2)||(meselect==2 && ran==0)){
                        resultLabel.setText("이겼습니다");
                       } else{
                        resultLabel.setText("졌습니다");
                       }
                   }
               });
        }
     
        panel02.add(label, BorderLayout.CENTER);
        panel02.add(comLabel);
        panel02.add(resultLabel);

        setSize(600, 500);
        setVisible(true);

    }
    public static void main(String[] args) {
        new RSPgame();
    }
}
