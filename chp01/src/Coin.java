import java.util.Scanner;

public class Coin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int won = scanner.nextInt();
        int oman = won / 50000;
        int man = won%50000 /10000;
        int ochun = won%10000 /5000;
        int chun = won%5000/1000;
        int oback = won%1000/500;
        int back = won%500/100;
        int osib = won%100/50;
        int sib = won%50/10;

        System.out.println(oman +" "+ man +" "+ ochun+" "+chun+" "+oback+" "+back+" "+osib+" "+sib);
        scanner.close();
    }
}
