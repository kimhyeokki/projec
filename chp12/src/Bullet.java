import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Bullet {
    private int speedY,posY;
    private int loadX;
    Image img;
    public boolean end;
    public Bullet(String imgsource ,int loadX,int posY , int speedY) {
        this.loadX = loadX;
       // loadY =-50;
        this.posY = posY;
        this.speedY = speedY;
        img = new ImageIcon(imgsource).getImage();
    }
      public void draw(Graphics g){
        g.drawImage(img,loadX, posY,null);
    }
    public void moveY(){
        posY -= speedY;
        if(posY<0)
        end=true;
    }
    public int getSpeedY() {
        return speedY;
    }
    public int getPosY() {
        return posY;
    }
    public int getLoadX() {
        return loadX;
    }
    public Image getImg() {
        return img;
    }
    public boolean isEnd() {
        return end;
    }
   
}
