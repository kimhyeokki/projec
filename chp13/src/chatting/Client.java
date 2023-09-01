package chatting;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//다중 채팅
//이름을 입력받아서 windoW
public class Client extends JFrame {
    
    private JTextField textField = new JTextField(30);
    private JTextArea textArea = new JTextArea(20,30);
    private String chattingName = "";
    private JLabel nikLabel =new JLabel();
    JPanel inputPanel ;
    JButton btn ;
    private Socket socket = null;
    private BufferedReader bufferedReader = null;
    private BufferedWriter bufferedWriter = null;
    String msg ;
    private ChattingArea receiver;
      Thread th ;
   
    Client(){
        chattingName = JOptionPane.showInputDialog(this,"닉네임을 쓰세요","닉네임",JOptionPane.YES_NO_OPTION);
        if(chattingName.length()==0||chattingName==null)
        {
            System.exit(0);
        }
        setTitle("멀티 채팅방");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        nikLabel.setText(chattingName);
        contentPane.add(nikLabel, BorderLayout.NORTH);
        contentPane.add(new JScrollPane(textArea),BorderLayout.CENTER);
        textArea.setEditable(false); //TextArea 글 못쓰게 할때
        textArea.append(chattingName+"님이 입장하셨습니다.");
        inputPanel = new JPanel();
        contentPane.add(inputPanel, BorderLayout.SOUTH);
        btn = new JButton("나가기");
        inputPanel.add(textField);
        inputPanel.add(btn);
        setSize(400,400);
        setVisible(true);
        receiver= new ChattingArea();
       contentPane.add(new JScrollPane(receiver));
        th = new Thread(receiver);
        th.start();

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                msg = textField.getText();
                try {
                    textArea.append("\n"+chattingName+ ":" +msg);
                    textField.setText("");
                    bufferedWriter.write(chattingName+ ":" +msg+"\n");
                    bufferedWriter.flush();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            }
            
        });

        try {
            socket = new Socket("192.168.0.11", 9998);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    class ChattingArea extends JTextArea implements Runnable{
        
        @Override
        public void run() {
            String outMsg = null;
            while(true){
               try {
                outMsg =  bufferedReader.readLine();
                this.append("\n"+outMsg);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
              int scrollPosition = this.getText().length();
                this.setCaretPosition(scrollPosition);
            }
        }

    }
    public static void main(String[] args) {
        new Client();
    }
}
