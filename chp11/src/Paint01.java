import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Paint01 extends JFrame {
    private Mypanel mypanel =new Mypanel();
    Paint01(){
        setTitle("그래픽");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mypanel);
        setSize(800, 800);
        setVisible(true);
    }
    class Mypanel extends JPanel{
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            g.setColor(Color.RED);
            for(int i=0;i<5; i++){
                for(int j=0;j<10;j++){
                    g.fillRect(81*j, 51*i, 80, 50);
                }
            }
            g.setColor(Color.BLACK);
            g.fillOval(400, 400, 20, 20); //원면그리기

            g.setColor(Color.BLUE);
            g.fillRect(400, 420, 100, 20);

            g.setColor(Color.RED);
            g.setFont(new Font("맑은 고딕", Font.BOLD, 40));
            g.drawString("Hello Java", 300 , 500);

            g.setColor(Color.BLUE);
            g.drawLine(500, 400, 600, 300);

            int x[] = {300,400,300,200};
            int y[] ={300,400,500,400};
            g.setColor(Color.YELLOW);
            g.fillPolygon(x,y,4); //다각형 그리기
            
            int x2[] = new int[6];
            int y2[] =new int[6];
            g.setColor(Color.BLACK);
            for(int i=0;i<6;i++){
                x2[i] =(int)(Math.sin(Math.PI*2*(i/6.0))*100)+300;
                y2[i] =(int)(Math.cos(Math.PI*2*(i/6.0))*100)+300;
            }
            g.fillPolygon(x2,y2,6); //육각형 그리기

            ImageIcon imageIcon = new ImageIcon("image/rocket.png");
            Image img = imageIcon.getImage();
            g.drawImage(img, 500, 500,64,64,null);
            // //g.drawRect(10, 10, 100, 100); //draw는 라인그리기
            // g.fillRect(10, 10, 100, 100); //filldraw 는 면그리기
            // g.setColor(Color.GREEN);
            // g.drawRect(20, 20, 100, 100);
            // g.setColor(Color.BLUE);
            // g.drawRect(30, 30, 100, 100);
            // //drawImage,
        }

    }

    public static void main(String[] args) {
        new Paint01();
    }
}
