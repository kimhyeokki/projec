import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame {
    JTextField sender = null;
    private Receiver receiver = null;

    private BufferedReader bufferedReader =null;
    private BufferedWriter bufferedWriter =null;
    private Socket socket =null;
    String inputmsg;
      Thread th;


    ChatClient(){
        setTitle("까까오 똑");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        sender = new JTextField();
        receiver = new Receiver();   //JTextArea 상속 받은 클래스 객체 선언
        sender.addActionListener(new ActionListener() {  //JtextFied 에 엔터 클릭시 
            @Override
            public void actionPerformed(ActionEvent e) {
              inputmsg =  sender.getText();    //입력한 글자..
              try {
                bufferedWriter.write(inputmsg+"\n");  //입력한 글자가 전송할 bufferedWriter에 
                bufferedWriter.flush();               //남아있는 데이터 모두 출력..
                receiver.append("\n client :" +inputmsg); // TextArea에 추가..
                sender.setText("");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            }
            
        });

        try {
            socket = new Socket("192.168.0.11", 9998);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        contentPane.add(new JScrollPane(receiver),BorderLayout.CENTER);//new JScrollPane() : 스크롤 생성
        contentPane.add(sender,BorderLayout.SOUTH);
        setSize(400, 400);
        setVisible(true);
        th = new Thread(receiver);
        th.start();
    }

    class Receiver extends JTextArea implements Runnable{
        @Override
        public void run() {
            //여기에 서버에서 오는 메세 실시간으로 뿌려주기
             String msg = null;
             while (true) {
                try {
                    msg = bufferedReader.readLine();  // bufferedWriter.write(inputmsg+"\n"); 
                    this.append("\n 서버 :"+msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                int scrollPosition = this.getText().length();
                this.setCaretPosition(scrollPosition);
                //스크롤 이동
            }
        }
    }
    public static void main(String[] args) {
        new ChatClient();
    }
}
