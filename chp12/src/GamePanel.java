import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    private Image ship = new ImageIcon("image/rocket.png").getImage();
    private Image alien = new ImageIcon("image/monster.png").getImage();
    private int posX = 400;
    private int posY = 400;
    private int alienposX = 500;
    private int alienposY = 500;
    private int shotY=0;
    private int shotX=28;
    private boolean isLeft,isRight,isUp,isDown,isSpace;
    private Thread th;
    private String score ="0";
    private int nums = Integer.parseInt(score);

    GamePanel(){
        this.setPreferredSize(new Dimension(1280, 720));
        th = new Thread(this);
        th.start();
        this.setFocusable(true);
        this.addKeyListener(new KeyListener() {                     //프로세스 스레드(여러가지일을 동시에)

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    isLeft=true;
                    // posX-=10;
                    // repaint();
                } else if(e.getKeyCode() ==KeyEvent.VK_RIGHT){
                    isRight = true;
                    //  posX +=10;
                    //  repaint();
                } else if(e.getKeyCode() ==KeyEvent.VK_UP){
                    isUp=true;
                }else if(e.getKeyCode() ==KeyEvent.VK_DOWN){
                    isDown=true;
                } else if(e.getKeyCode() ==KeyEvent.VK_SPACE){
                    isSpace=true;
                  
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    isLeft=false;
                } else if(e.getKeyCode() ==KeyEvent.VK_RIGHT){
                    isRight = false;
                }else if(e.getKeyCode() ==KeyEvent.VK_UP){
                    isUp=false;
                    posY=700;
                }else if(e.getKeyCode() ==KeyEvent.VK_DOWN){
                    isDown=false;
                }else if(e.getKeyCode() ==KeyEvent.VK_SPACE){
                    isSpace=true;
                  
                }
            }
            
        });
    }
    public void check(){
      double distX = posX-alienposX;
      double distY = posY-alienposY;
      double dist = Math.sqrt(Math.pow(distX,2)+Math.pow(distY,2));
      double disy02 = (posY+shotY)-alienposY;
      double dist02 = Math.sqrt(Math.pow(distX+28,2)+Math.pow(disy02,2));
      
      if(dist <60){
        System.out.println("충돌");
        
        alienposX =0;
        alienposY =(int)(Math.random()*400);
        nums +=10;
      }
      if(dist02 <25){
        System.out.println("충돌");
        alienposX =0;
        //alienposX =(int)(Math.random()*1280);
        alienposY =(int)(Math.random()*400); 
        nums +=10;
      }
    }
    public void move(){
        if(isLeft){
            posX -=10;
        } if(isRight){
            posX +=10;
        } 
        if(isUp){
            posY -=10;
        } 
       
        if(isDown){
            posY +=10;
        }
        if(alienposX==0){  //충돌일때 
            for(int i=0;i<(int)(Math.random()*1280);i++){
                alienposX +=10;
            } 
        }
    }
    public void shoot(){
        if(isSpace){
               shotY -=10;
                 if(posY+shotY<0){
                     shotY =0;
                 }
             }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(ship, posX,posY,null);
        g.fillOval(posX+shotX, posY+shotY, 10, 10);
       // g.fillOval(posX+28, posY+shotY02, 10, 10);
        g.drawImage(alien,alienposX,alienposY,null);
        g.drawString("Score :"+String.valueOf(nums), 20, 20);
       
    }
    @Override
    public void run() {
        //일처리하는 곳
        while(true){ //무한루프에 빠트리고
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            move();
            check();
            repaint();
            shoot();
        }
        
    }

}
