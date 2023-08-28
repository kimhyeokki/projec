import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class FruitsList{
    private String img;
    private String title;

    public FruitsList(String img, String title) {
        this.img = img;
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }
}
class CarPanel extends JPanel{
    private JLabel imJLabel = new JLabel();
    private JLabel txtJLabel = new JLabel();
    CarPanel(){};
    CarPanel(String img, String title){
        imJLabel.setIcon(new ImageIcon("image/"+img));
        txtJLabel.setText(title);
        add(imJLabel,BorderLayout.NORTH);
        add(txtJLabel,BorderLayout.CENTER);
    }
    public void Change(String img, String title){
        imJLabel.setIcon(new ImageIcon("image/"+img));
        txtJLabel.setText(title);
    }
}
public class Fruit extends JFrame {
    private int num =2;
    Fruit(){
        ArrayList<FruitsList> abc = new ArrayList<>();
        abc.add(new FruitsList("사과.png", "사과"));
        abc.add(new FruitsList("배.png", "배"));
        abc.add(new FruitsList("포도.png", "포도"));
        abc.add(new FruitsList("귤.png", "귤"));
        abc.add(new FruitsList("딸기.png", "딸기"));
        abc.add(new FruitsList("망고.png", "망고"));
        abc.add(new FruitsList("멜론.png", "멜론"));
        abc.add(new FruitsList("바나나.png", "바나나"));
        abc.add(new FruitsList("복숭아.png", "복숭아"));
        abc.add(new FruitsList("수박.png", "수박"));
        abc.add(new FruitsList("오렌지.png", "오렌지"));
        abc.add(new FruitsList("파인애플.png", "파인애플"));
        String fruits[] ={
            "사과.png",
            "배.png",
            "포도.png",
            "귤.png",
            "딸기.png",
            "망고.png",
            "멜론.png",
            "바나나.png",
            "복숭아.png",
            "수박.png",
            "오렌지.png",
            "파인애플.png",
        };
        String fruitsTxt[] ={
            "사과",
            "배",
            "포도",
            "귤",
            "딸기",
            "망고",
            "멜론",
            "바나나",
            "복숭아",
            "수박",
            "오렌지",
            "파인애플",
        };

        setTitle("좋아하는 과일 고르기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("당신이 좋아하는 과일을 고르세요");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
        contentPane.add(titleLabel,BorderLayout.NORTH);

        JLabel imagLabel = new JLabel(new ImageIcon("image/"+abc.get(0).getImg()));
        JLabel imJLabelTxt = new JLabel(abc.get(0).getTitle());
        imJLabelTxt.setHorizontalAlignment(JLabel.CENTER);
        JLabel imagLabel02 = new JLabel(new ImageIcon("image/"+abc.get(1).getImg()));
        JLabel imJLabelTxt02 = new JLabel(abc.get(1).getTitle());
         imJLabelTxt02.setHorizontalAlignment(JLabel.CENTER);
        JPanel mainpanel = new JPanel();
        contentPane.add(mainpanel);
        
        JPanel leftPanel = new JPanel();
        mainpanel.add( leftPanel);
        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(imagLabel,BorderLayout.NORTH);
         leftPanel.add(imJLabelTxt,BorderLayout.CENTER);

        JPanel rightPanel = new JPanel();
        mainpanel.add(rightPanel);
       rightPanel.setLayout(new BorderLayout());
       rightPanel.add(imagLabel02,BorderLayout.NORTH);
       rightPanel.add(imJLabelTxt02,BorderLayout.CENTER);

        imagLabel.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
                imagLabel02.setIcon(new ImageIcon("image/"+fruits[num]));
                imJLabelTxt02.setText(fruitsTxt[num]);
                num++;
                if(num>=12){
                    titleLabel.setText("당신이 제일 좋아하는 과일은 "+imJLabelTxt.getText()+"입니다");
                    rightPanel.setVisible(false);
                    imagLabel.removeMouseListener(this);
                }

             }
        });
        imagLabel02.addMouseListener(new MouseAdapter() {
             public void mouseClicked(MouseEvent e) {
              imagLabel.setIcon(new ImageIcon("image/"+fruits[num]));
                imJLabelTxt.setText(fruitsTxt[num]);
                num++;
                if(num>=12){
                    titleLabel.setText("당신이 제일 좋아하는 과일은 "+imJLabelTxt02.getText()+"입니다");
                    leftPanel.setVisible(false);
                    imagLabel02.removeMouseListener(this);
                }
             }
        });
       // contentPane.add(imagLabel,BorderLayout.CENTER);        
        setSize(800, 600);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Fruit();
    }
}
