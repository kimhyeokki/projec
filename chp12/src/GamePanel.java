import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
    private Image ship = new ImageIcon("image/spaceship.png").getImage();
   // private Image alien = new ImageIcon("image/monster.png").getImage();
   private Image space = new ImageIcon("image/space.jpg").getImage();
    Monster monster= new Monster("image/monster.png", 300,-50, 10);
    private List<Monster> monsterList = new ArrayList<>();
    private int posX = 400;
    private int posY = 400;
    private boolean isLeft,isRight,isUp,isDown,isSpace;
    private Thread th;
    Bullet bullet = new Bullet("image/bullet.png", posX, posY, 0);
    private List<Bullet> bulletList = new ArrayList<>();
    private List<Boom> boomList = new ArrayList<>();
    //---------------------------------------// 
    private String score ="100";  //점수 작성하기 위해 문자로 받고
    private int nums = Integer.parseInt(score); // 숫자로 증가하려면 문자 score에 선언된 숫자를 int로 변환
    int number =0;
    //---------------------------------------// 시간 label 생성
    JLabel label= new JLabel();
    int msec =0;
    int sec =0;
    int min =0;
     //--------------------------------------//
     private boolean isPressed;
     private int bulletCount=0;
     private String monsterimgList[] ={"monster.png","monster02.png","monster03.png"};
    GamePanel(){
        this.setPreferredSize(new Dimension(1280, 720));
        th = new Thread(this);
        th.start();
        this.setFocusable(true);    
        this.add(label); //시간 label 자기자신의 panel에 추가
        this.addKeyListener(new KeyListener() {                     //프로세스 스레드(여러가지일을 동시에)
            public void keyTyped(KeyEvent e) {
            }
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    isLeft=true;
                } else if(e.getKeyCode() ==KeyEvent.VK_RIGHT){
                    isRight = true;
                } else if(e.getKeyCode() ==KeyEvent.VK_UP){
                    isUp=true;
                }else if(e.getKeyCode() ==KeyEvent.VK_DOWN){
                    isDown=true;
                }  
                if(e.getKeyCode() ==KeyEvent.VK_SPACE){
                    isPressed=true;
                }
            }
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
                    isPressed=false;
                }
            }
        });
    }
    public void bullet(){
        if(isPressed){
            if(bulletCount >3){
                    Bullet bullet = new Bullet("image/bullet.png", posX+32-8, posY , 10);
                    bulletList.add(bullet);  //bullet 미사일 생성
                    bulletCount =0;
            } else{
                bulletCount++;
            }
        }
    }
    public void check(){
    for(int i=0;i<bulletList.size();i++){
            Bullet bullet = (Bullet)bulletList.get(i);
            for(int j=0;j<monsterList.size();j++){
                Monster monster = monsterList.get(j);
               Rectangle bulletrect01 = new Rectangle(bullet.getLoadX(),bullet.getPosY(),16,16);
               Rectangle monsterrect01 = new Rectangle(monster.getLoadX(),monster.getPosY(),32,32);
             //Rectangle xxx(사각형 생성)    
             //Rectangle yyy(사각형 생성)    xxx.interscts.yyy (boolean 타입 겹치면 true, 아니면 false)
               if(hitTest(bulletrect01,monsterrect01)){  //
                    monsterList.remove(j);
                    bulletList.remove(i);
                    nums+=10;
                    Boom boom = new Boom("image/boom.png",monster.getLoadX(),monster.getPosY());
                    boomList.add(boom); 
                }
            }
        }
            for(int j=0;j<monsterList.size();j++){
                Monster monster = monsterList.get(j);
               Rectangle monsterrect01 = new Rectangle(monster.getLoadX(),monster.getPosY(),32,32);
               Rectangle shiprect01 = new Rectangle(posX,posY,32,32);
                if(hitTest(monsterrect01,shiprect01)){
                    monsterList.remove(j);
                    nums -=10;
                    Boom boom = new Boom("image/boom.png",monster.getLoadX(),monster.getPosY());
                    boomList.add(boom); 
                }
            }
    }
    public boolean hitTest(Rectangle rect01,Rectangle rect02){
        return rect01.intersects(rect02);
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
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(space, 0, 0, null);
        g.drawImage(ship, posX,posY,null);
       for(int i=0;i<monsterList.size();i++){
        Monster monster = monsterList.get(i);
           monster.draw(g);
       }
       for(int i=0;i<bulletList.size();i++){
        Bullet bullet = bulletList.get(i);
        bullet.draw(g);
       }
       for(int i=0;i<boomList.size();i++){
        Boom boom = boomList.get(i);
        boom.draw(g);
       }
       g.setColor(Color.RED);
       g.setFont(new Font("맑은 고딕",Font.BOLD, 25));
        g.drawString("Score :"+nums, 20, 20);  //score 점수 확인
    }

    public void makeMonster(){ //몬스터 생성 메서드
        String img = monsterimgList[(int)(Math.random()*3)];
        if(Math.random()<0.05){
      Monster monster = new Monster("image/"+img,(int)(Math.random()*1200),-50,(int)(Math.random()*2+2));
        monsterList.add(monster);
        }
    }
    void monsterMove(){
         for(int i=0;i<monsterList.size();i++){
        Monster monster = monsterList.get(i);
        monster.moveY();
       }
       
    }
    void bulletMove(){
        for(int i=0;i<bulletList.size();i++){
            Bullet bullet = bulletList.get(i);
            bullet.moveY();
        }
    }
    void boomdisapper(){
        for(int i=0;i<boomList.size();i++){
            Boom boom = boomList.get(i);
            boom.disappear();
        }
    }
    void removeMonster(){
         for(int i=0;i<monsterList.size();i++){
        Monster monster = monsterList.get(i);
        if(monster.end){
            monsterList.remove(i);
            nums -=10;
        }
       }
    }
    void removeBullet(){
         for(int i=0;i<bulletList.size();i++){
        Bullet bullet  = bulletList.get(i);
        if(bullet.end){
            bulletList.remove(i);
        }
       }
    }
    void removeBoom(){
         for(int i=0;i<boomList.size();i++){
        Boom boom  = boomList.get(i);
        if(boom.end){
            boomList.remove(i);
        }
       }
    }
    @Override
    public void run() {
        //일처리하는 곳
        while(true){ //무한루프에 빠트리고
            label.setText(min+":"+sec+":"+msec);
            msec++;
            if(msec==60){
            msec=0;
            sec++;
            label.setText(min+":"+sec+":"+msec);
        } if(sec==60){
            sec=0;
            min++;
            label.setText(min+":"+sec+":"+msec);
        }
            try {
                Thread.sleep(10);
                if(nums==0){
                    return;          
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            move();
            makeMonster();
            monsterMove();
            bullet();
            bulletMove();
            removeMonster();
            removeBullet();
            boomdisapper();
            removeBoom();
            check();
            repaint();
        }
        
    }

}
