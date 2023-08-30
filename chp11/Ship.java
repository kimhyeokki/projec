import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Ship extends JPanel implements Runnable{
    private Image ship = new ImageIcon("image/rocket.png").getImage();
    private int posX = 400;
    private int posY = 400;
    private int shotY,shotY02;
    private boolean isLeft,isRight,isUp,isDown,isSpace;
    private Thread th;
    private int count =0;
    Ship(){
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
                }else if(e.getKeyCode() ==KeyEvent.VK_DOWN){
                    isDown=false;
                }else if(e.getKeyCode() ==KeyEvent.VK_SPACE){
                    isSpace=true;
                  
                }
            }
            
        });
    }
    public void move(){
        if(isLeft){
            posX -=10;
        }else if(isRight){
            posX +=10;
        }else if(isUp){
            posY -=10;
        }else if(isDown){
            posY +=10;
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
        g.fillOval(posX+28, posY+shotY, 10, 10);
        g.fillOval(posX+28, posY+shotY02, 10, 10);
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
            repaint();
            shoot();
        }
        
    }

}
