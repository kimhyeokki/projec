import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.w3c.dom.events.MouseEvent;

public class KeyListenerTest extends JFrame{
    JLabel label = new JLabel("Hello Java");
    KeyListenerTest(){
    setTitle("KeyListener");
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 500);   
    Container container = this.getContentPane();
    container.setFocusable(true);  
    //container.addKeyListener(new MyKeyListener());
    container.addKeyListener(new MyKeyAdapter());
    container.setLayout(null);
    container.add(label);
    label.setSize(50, 20);
    label.setLocation(100, 100);
    }
    class MyKeyAdapter extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e) {
           //label.setText(KeyEvent.getKeyText(e.getKeyCode()));
           switch(e.getKeyCode()){
            case KeyEvent.VK_LEFT :
            label.setLocation(label.getX()-10, label.getY()); 
            break;
            case KeyEvent.VK_RIGHT :
            label.setLocation(label.getX()+10, label.getY()); 
             break;
            case KeyEvent.VK_UP :
            label.setLocation(label.getX(), label.getY()-10); 
             break;
            case KeyEvent.VK_DOWN :
            label.setLocation(label.getX(), label.getY()+10); 
             break;
           }
        }

        @Override
        public void keyTyped(KeyEvent e) {
         
        }
        
    }
    class MyKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
           label.setText(Integer.toString(e.getKeyCode()));
           //== label.setText(""+e.getKeyCode());
           System.out.println("Click");
           

        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
        
    }
    
    public static void main(String[] args) {
        new KeyListenerTest();
    }
}
