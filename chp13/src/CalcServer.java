import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalcServer {
    
    
    
    public static void main(String[] args) {
        Socket socket = null;
        Scanner sc = new Scanner(System.in);
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            ServerSocket serverSocket =new ServerSocket(9999);
            System.out.println("나는 연결대기중입니다.");
            socket= serverSocket.accept();  //소켓을 받을 수 있게 해줌(타입은 Socket)
            System.out.println("나는 연결되었습니다.");
            //Socket 만들어짐
            //서버먼저 실행
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while(true){
              String inputmsg = bufferedReader.readLine();

              System.out.println("클라이언트 : "+inputmsg);
              
                 System.out.println("보내기>>>");
                String outpuString = sc.nextLine();
                bufferedWriter.write(outpuString+"\n");
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }    
    }
}
