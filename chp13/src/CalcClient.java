import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class CalcClient {
    public static void main(String[] args) {
        Socket socket = null;
        Scanner sc = new Scanner(System.in);
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            socket = new Socket("192.168.0.11", 9999);
            //"localhost"
            //"192.168.0.23"
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while(true){
                System.out.println("보내기>>>");
                String outpuString = sc.nextLine();
                bufferedWriter.write(outpuString+"\n");
                bufferedWriter.flush();
                String inputmsg = bufferedReader.readLine();
                System.out.println("서버 : "+inputmsg); 
            }
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

//192.168.0.11
