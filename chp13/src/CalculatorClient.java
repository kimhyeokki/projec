import java.awt.Container;
import java.awt.FlowLayout;
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
import javax.swing.JTextField;

public class CalculatorClient extends JFrame {
    private JTextField firsTextField = new JTextField(5);
    private JTextField operatorTextField = new JTextField(5);
    private JTextField secondTextField = new JTextField(5);
    private JTextField resultTextField = new JTextField(5);
    private JButton btn = new JButton("계산");

    private Socket socket =null;
    private BufferedReader bufferedReader = null;
    private BufferedWriter bufferedWriter =null;


    CalculatorClient(){
         setTitle("계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(firsTextField);
        contentPane.add(operatorTextField);
        contentPane.add(secondTextField);
        contentPane.add(new JLabel("="));
        contentPane.add(resultTextField);
        contentPane.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
             String first =  firsTextField.getText().trim();
             String operator =    operatorTextField.getText().trim();
             String second =  secondTextField.getText().trim();

            try {  //BufferedReader, BufferedWriter 는 Try/Catch가 필요
                bufferedWriter.write(first+"\n");
                bufferedWriter.write(operator+"\n");
                bufferedWriter.write(second+"\n");
                bufferedWriter.flush();
                
                String result = bufferedReader.readLine();
                resultTextField.setText(result);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            }
            
        });
        
        
        setSize(400, 400);
        setVisible(true);
        try {
            socket = new Socket("localhost", 9997);
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
    public static void main(String[] args) {
        new CalculatorClient();
    }
}
