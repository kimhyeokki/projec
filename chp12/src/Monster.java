import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Monster {
    private int speedY;
    private int loadX,posY;
    public int getLoadX() {
        return loadX;
    }
    public int getPosY() {
        return posY;
    }
    Image img;
    public boolean end;
    public Monster(String imgsource ,int loadX,int posY , int speedY) {
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
        posY +=speedY;
        if(posY>850)
        end=true;
    }
   
}
