import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Snow00 {   //눈 움직이기 위한 클래스 생성
    private int posX; 
    private int posY;  
    private int speedY;
    private int width; //눈의 x,t좌표, 내려가는 스피드, 눈의 면적
    private double t=0;
    private int loadX; // 중심축
    public Snow00(int loadX, int posY, int speedY,int width) {  //생성자 생성
        this.loadX = loadX;
        this.posY = posY;
        this.speedY = speedY;
        this.width = width;
    }
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(posX, posY, width,width);
    }
    public void moveY(){
        posY +=speedY;
        posX = (int)(Math.cos(t)*50)+loadX;  //loadX 중심으로 -50~50 사이로 움직인다.
        t+=0.02; //좌우로 움직일 때 속도 조절
        if(posY>500){
            posY = -20;
            speedY = (int)(Math.random()*5+1);
            posX = (int)(Math.random()*400);
            width =(int)(Math.random()*10+1);
        }
    }
}

class Snow extends JPanel implements Runnable{  //JPanel 상속 받는중
    private Image bg = new ImageIcon("image/town.jpg").getImage();
    private List<Snow00> snowList = new ArrayList<>();  //Snow00에서 생성된 눈들을 snowList에 담기위해 선언
    Thread th;
    Snow(){
        for(int i=0;i<50;i++){
            Snow00 snow = new Snow00((int)(Math.random()*640), (int)(Math.random()*427), (int)((Math.random()*3)+1), (int)((Math.random()*8)+2));
            snowList.add(snow); // snowList에 눈생성..
        }
        th =new Thread(this);
        th.start();
    }
    
    private void drawSnow(Graphics g){   
        for(int i=0;i<snowList.size();i++){
            Snow00 snow = snowList.get(i); //snowList에 각각 생성된 Snow00의 생성자및 메서드
            snow.draw(g);                  // 그중에 draw()만 생성
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(getGraphics());
        g.drawImage(bg, 0,0, null);
        drawSnow(g);
    }

    @Override
    public void run() {
        while (true) {
          try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            for(int i =0;i<snowList.size();i++){
                Snow00 snow = snowList.get(i); //snowList에 각각 생성된 Snow00의 생성자및 메서드
                snow.moveY();                  // 그중에 moveY()만 생성
            }
            repaint();
        }
    }

}

public class SnowTown extends JFrame {
      SnowTown(){
        setTitle("눈내리는 마을");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new Snow());
        setSize(640, 427);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SnowTown();
    }
}
