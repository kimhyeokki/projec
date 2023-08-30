import javax.swing.JFrame;

public class GameApp extends JFrame {
    GameApp(){
        setTitle("shooting Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new GamePanel());
        this.pack(); //
        setVisible(true);
    }
    public static void main(String[] args) {
        new GameApp();
    }
}
