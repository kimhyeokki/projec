import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



class MoveCircle extends JPanel implements Runnable{
    int posX=100;
    int posY=100;
    Thread thread;
    MoveCircle(){
        thread = new Thread(this);
     //   thread.start();
        JButton btn = new JButton("클릭");
        add(btn);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("dsad");
                thread.start();
            }  
        });
    }

    @Override
    public void run() {
        Random ran = new Random();
        while (true) {
            posX = ran.nextInt(300);
            posY = ran.nextInt(300);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
            repaint();
        }

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawOval(posX, posY, 100, 100);
    }
}


public class RandomMove extends JFrame {
    RandomMove(){
        setTitle("시계");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new MoveCircle());
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RandomMove();
    }
}
