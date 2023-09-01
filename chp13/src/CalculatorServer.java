import java.awt.Container;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CalculatorServer extends JFrame {
    private JTextArea logArea = new JTextArea();

    CalculatorServer() {
        this.setTitle("계산기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.add(new JScrollPane(logArea));

        this.setSize(400, 200);
        this.setVisible(true);
        ServerThread serverThread = new ServerThread();
        serverThread.start();
    }

     class ServerThread extends Thread {  //여러 클라이언트랑 연결하기 위한 스레드를 활용
        @Override
        public void run() {
            ServerSocket serverSocket = null;
            Socket socket = null;
            try {
                serverSocket = new ServerSocket(9997);
                while (true) {
                    socket = serverSocket.accept();  //9997 포트에 연결
                    logArea.append("클라이언트 연결 됨 \n");
                    CalcThread calcThread = new CalcThread(socket);  //계산담당 스레드
                    calcThread.start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    class CalcThread extends Thread {
        private BufferedReader bufferedReader = null;
        private BufferedWriter bufferedWriter = null;
        private Socket socket = null;

        CalcThread(Socket socket) {
            this.socket = socket;  //9997포트
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            while(true){
                try {
                    String first = bufferedReader.readLine();
                    String operator = bufferedReader.readLine();
                    String second = bufferedReader.readLine();
                    
                    int firstInt =Integer.parseInt(first);
                    int secondInt =Integer.parseInt(second);
                    int result =0;
                    if(operator.equals("+")){
                        result =firstInt+secondInt;
                    }else if(operator.equals("-")){
                        result =firstInt-secondInt;
                    }else if(operator.equals("*")){
                        result =firstInt*secondInt;
                    }else if(operator.equals("/")){
                        result =firstInt/secondInt;
                    }else{
                        result =0;
                    }

                    bufferedWriter.write(Integer.toString(result)+"\n"); //클라이언트로 보내기 위해 서버에 작성
                    bufferedWriter.flush();
                    logArea.append(first+operator+second+"="+result+"\n");  //서버의 JTextArea에 추가
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
        public static void main(String[] args) {
        new CalculatorServer();
    }
}
