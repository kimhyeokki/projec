import java.awt.Container;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Quiz03 extends JFrame {
    
    JLabel label = new JLabel("Hello Java");
    Quiz03(){
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
           char temp;
           String name = label.getText();
           switch (e.getKeyCode()) {
           case KeyEvent.VK_RIGHT:
           for(int i =0;i<name.length();i++){
              String first =  name.substring(0, 1);
              String rest = name.substring(1);
              label.setText(rest+first);
           }
           break;
            case KeyEvent.VK_LEFT:
              for(int i =0;i<name.length();i++){
              String last =  name.substring(name.length()-1);
              String rest = name.substring(0,name.length()-1);
              label.setText(last+rest);
              System.out.println(last);
            }
            break;
        }
        }

        @Override
        public void keyTyped(KeyEvent e) {
         
        }
        
    }
    public static void main(String[] args) {
        new Quiz03();
    }
}
