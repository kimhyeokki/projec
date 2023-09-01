import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer extends JFrame {
    JTextField sender = null;
    private Receiver receiver = null;

    private BufferedReader bufferedReader =null;
    private BufferedWriter bufferedWriter =null;
    private Socket socket =null;
    ServerSocket serverSocket =null;
    String inputmsg;
    Thread th;
    ChatServer(){
        setTitle("까까오 똑 서버");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        sender = new JTextField();
        receiver = new Receiver();
        sender.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              inputmsg =  sender.getText();
              try {
                  bufferedWriter.write(inputmsg+"\n");
                bufferedWriter.flush();
                receiver.append("\n server :" +inputmsg);
                sender.setText("");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            }  
        });

        try {
            serverSocket =new ServerSocket(9998);
            System.out.println("나는 연결대기중입니다.");
            socket= serverSocket.accept();  //소켓을 받을 수 있게 해줌(타입은 Socket)
            receiver.append("클라이언트 연결됨");
            //System.out.println("나는 연결되었습니다.");
            //Socket 만들어짐
            //서버먼저 실행
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        contentPane.add(new JScrollPane(receiver),BorderLayout.CENTER);
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
                    msg = bufferedReader.readLine();
                    this.append(" \n 클라이언트 :"+msg);
                    
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
        new ChatServer();
    }
}
