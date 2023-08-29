import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ListTest extends JFrame {
    private String fruits [] = {"apple","plum","grape","orange","apple","plum","grape","orange"};
    private Vector<String> vector = new Vector<>();
     
    ListTest(){
        setTitle("");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane =this.getContentPane();
        contentPane.setLayout(new FlowLayout());

        JList<String> strList = new JList<>(fruits);
        JList<String> vecList = new JList<>(vector);
        vector.add("bear");
        vector.add("tiger");
        vector.add("lion");
        vector.add("dog");
        contentPane.add(new JScrollPane(strList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        contentPane.add(new JScrollPane(vecList));
        vector.add("cat");
        vecList.setListData(vector);
        strList.setVisibleRowCount(4);
        strList.setFixedCellWidth(150);
        setSize(500, 500);
        setVisible(true);

    }
    public static void main(String[] args) {
        new ListTest();
    }
}
