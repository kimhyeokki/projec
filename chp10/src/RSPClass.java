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


public class RSPClass extends JFrame {
    private ResultPanel resultPanel = new ResultPanel();
    private ItemPanel itemPanel = new ItemPanel();
    
    RSPClass(){
        setTitle("가위바위보");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane =this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(itemPanel,BorderLayout.NORTH);    
        contentPane.add(resultPanel,BorderLayout.CENTER);   

        setSize(600, 500);
        setVisible(true);

    }
    class ItemPanel extends JPanel{
    private JButton btnList[] = new JButton[3];
    ImageIcon abc = new ImageIcon("image/paper.png");
    Image originImage = abc.getImage();
    Image resizImage = originImage.getScaledInstance(70, 65, Image.SCALE_SMOOTH);
    private ImageIcon imageList[] ={
        new ImageIcon("image/rock.png"),
        new ImageIcon("image/scissors.png"),
        new ImageIcon(resizImage)
};
 ItemPanel(){
     setLayout(new FlowLayout(FlowLayout.CENTER));
      for(int i=0;i<3;i++){
            btnList[i] =new JButton(imageList[i]);
            add(btnList[i]);
            int meselect = i;
            btnList[i].addMouseListener(new MouseAdapter() {
                  public void mouseClicked(MouseEvent e) {
                      Random random = new Random();
                        int ran = random.nextInt(3);
                    resultPanel.meLabel.setIcon(btnList[meselect].getIcon());
                    resultPanel.comLabel.setIcon(btnList[ran].getIcon());
                       if(ran == meselect){
                            resultPanel.judge("비겼습니다");
                       }else if((meselect==0 && ran==1) || (meselect==1 && ran==2)||(meselect==2 && ran==0)){
                        resultPanel.judge("이겼습니다");
                       } else{
                        resultPanel.judge("졌습니다");
                       }
                   
                  }
            });
      }
 }
}


class ResultPanel extends JPanel{
    private JLabel meLabel = new JLabel("Me");
    private JLabel comLabel = new JLabel("COM");
    private JLabel resultLabel = new JLabel("");
    
    ResultPanel(){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(meLabel);
        add(comLabel);
        add(resultLabel);
    }
    public void judge(String resultTxt){
        resultLabel.setText(resultTxt);
    }

}
    public static void main(String[] args) {
        new RSPClass();
    }
}
