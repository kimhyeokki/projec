import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TextFiledTest extends JFrame {
    TextFiledTest(){
        setTitle("TextFiled test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        JLabel label01 = new JLabel("ID");
        JTextField text01 = new JTextField(20);
        JLabel label02 = new JLabel("PW");
        JPasswordField text02 = new JPasswordField(20);
        JButton btn01 = new JButton("로그인");

        contentPane.add(label01);
        contentPane.add(text01);
       
        contentPane.add(label02);
        contentPane.add(text02);
        
        contentPane.add(btn01);
        btn01.addActionListener(new ActionListener() {
                //아이디가 khk1103  pw 1234 이면 통과
            @Override
            public void actionPerformed(ActionEvent e) {
                text01.getText();//ID 
                text02.getPassword();     //PasswordFiled 에선      
                String pw = new String(text02.getPassword());  //pw  char[] 를 String으로 변환하기 위한 3가지 방법
                String pw01 = String.valueOf(text02.getPassword());
                String pw02 = String.copyValueOf(text02.getPassword());

               if(text01.getText().equals("khk1103")&&pw.equals("1234")){
                   System.out.println("정답");
                   JOptionPane.showMessageDialog(null, "로그인 되었습니다");
                   //aerlt 창
                }else{
                    JOptionPane.showMessageDialog(null, "누구냐 넌");
                }
            }
            
        });

        setSize(500, 500);
        setVisible(true);
    }
    public static void main(String[] args) {
        new TextFiledTest();
    }
}
