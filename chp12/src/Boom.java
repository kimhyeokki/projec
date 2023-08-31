import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Boom {
    Image img =  new ImageIcon("image/boom.png").getImage();
      private int loadX,posY;
      int count;
      public boolean end;
      public Boom(String imgsource ,int loadX,int posY) {
        this.loadX = loadX;
       // loadY =-50;
        this.posY = posY;
        img = new ImageIcon(imgsource).getImage();
    }
    public void draw(Graphics g){
          g.drawImage(img,loadX,posY,null);
    }
 public void disappear()
    {      count++;
        if(count>30)
        end=true;
    }
    public Image getImg() {
        return img;
    }

    public int getLoadX() {
        return loadX;
    }

    public int getPosY() {
        return posY;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public void setLoadX(int loadX) {
        this.loadX = loadX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
