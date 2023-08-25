import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class MouseListenerTest extends JFrame {
    JLabel label = new JLabel("Hello Java");
    MouseListenerTest(){
        setTitle("MouseListener");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container container = this.getContentPane();
        //container.addMouseListener(new MyMouseListener());
        container.addMouseListener(new MyMouseApater());
        container.setLayout(null);
        container.add(label);
        label.setSize(50, 20);
        label.setLocation(100, 100);
        setSize(500, 500);
    }
    class MyMouseApater extends MouseAdapter{  //Adapter는 내부적으로 구현하고 있어서 extends, 내가 원하는 것만
                                               //override 할 수 있다.

        @Override
        public void mousePressed(MouseEvent e) {
           label.setLocation(e.getX(), e.getY());
        }

    }
    class MyMouseListener implements MouseListener{
    MyMouseListener(){
        
    }
    @Override
    public void mouseClicked(MouseEvent e) {
                System.out.println("click");
                
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("pressed");
        label.setLocation(e.getX(),e.getY());
        
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
            System.out.println("released");
           // label.setLocation(e.getX(),e.getY());

    }

    @Override
    public void mouseEntered(MouseEvent e) {
                System.out.println("enter");
                //label.setLocation(e.getX(),e.getY());

    }

    @Override
    public void mouseExited(MouseEvent e) {
                System.out.println("exited");

    }
}
    public static void main(String[] args) {
        new MouseListenerTest();
    }
}
